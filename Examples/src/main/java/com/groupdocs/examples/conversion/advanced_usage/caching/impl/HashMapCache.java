package com.groupdocs.examples.conversion.advanced_usage.caching.impl;

import com.groupdocs.conversion.caching.ICache;

public class HashMapCache implements ICache {

    private final java.util.Map<String, Object> cache = new java.util.HashMap<>();

    @Override
    public void set(String key, Object data) {
        cache.put(key, data);
    }

    @Override
    public Object tryGetValue(String key) {
        return cache.get(key);
    }

    @Override
    public Iterable<String> getKeys(String filter) {
        if (filter != null && !filter.isEmpty()) {
            java.util.ArrayList<String> keys = new java.util.ArrayList<>();
            for (String k : cache.keySet()) {
                if (k.contains(filter)) {
                    keys.add(k);
                }
            }
            return keys;
        } else {
            return cache.keySet();
        }
    }
}
