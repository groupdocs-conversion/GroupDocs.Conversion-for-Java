package com.groupdocs.conversion.examples.advanced_usage.caching;

public class RedisCache implements ICache, IDisposable {

    private String _cacheKeyPrefix;

    private ConnectionMultiplexer _redis;
    private IDatabase _db;
    private String _host = "192.168.0.1:6379";

    public RedisCache(String cacheKeyPrefix)
    {
        _cacheKeyPrefix = cacheKeyPrefix;
        _redis = ConnectionMultiplexer.Connect(_host);
        _db = _redis.GetDatabase();
    }

    public void Set(String key, Object data)
    {
        if (data == null)
            return;

        string prefixedKey = GetPrefixedKey(key);
        using (MemoryStream stream = GetStream(data))
        {
            _db.StringSet(prefixedKey, RedisValue.CreateFrom(stream));
        }
    }

    public boolean TryGetValue(String key, Object value)
    {
        var prefixedKey = GetPrefixedKey(key);
        var redisValue = _db.StringGet(prefixedKey);

        if (redisValue.HasValue)
        {
            var data = Deserialize(redisValue);
            value = data;

            return true;
        }


        value = default;
        return false;
    }

    public IEnumerable<string> GetKeys(string filter)
    {
        return _redis.GetServer(_host).Keys(pattern: $"*{filter}*")
        .Select(x => x.ToString().Replace(_cacheKeyPrefix, string.Empty))
        .Where(x => x.StartsWith(filter, StringComparison.InvariantCultureIgnoreCase))
        .ToList();
    }

    private String GetPrefixedKey(string key)
    => $"{_cacheKeyPrefix}{key}";

    private Object Deserialize(RedisValue redisValue)
    {
        Object data;
        using (MemoryStream stream = new MemoryStream(redisValue))
        {
            BinaryFormatter formatter = new BinaryFormatter
            {
                Binder = new IgnoreAssemblyVersionSerializationBinder()
            };

            try
            {
                data = formatter.Deserialize(stream);
            }
            catch (SerializationException)
            {
                data = null;
            }
        }

        return data;
    }

    private MemoryStream GetStream(Object data)
    {
        MemoryStream result = new MemoryStream();

        if (data is Stream stream)
        {
            stream.Position = 0;
            stream.CopyTo(result);
        }
        else
        {
            BinaryFormatter formatter = new BinaryFormatter();
            formatter.Serialize(result, data);
        }

        return result;
    }

    public void Dispose()
    {
        _redis.Dispose();
    }

    private class IgnoreAssemblyVersionSerializationBinder : SerializationBinder

    {
        public override Type BindToType(string assemblyName, string typeName)
        {
            string assembly = Assembly.GetExecutingAssembly().FullName;
            Type type = Type.GetType($"{typeName}, {assembly}");

            return type;
        }
    }
}