package com.groupdocs.examples.conversion.advanced_usage.caching.impl;

import com.groupdocs.conversion.caching.ICache;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCache implements ICache {

    private final Path _cacheDirectory;

    public FileCache(Path cacheDirectory) {
        this._cacheDirectory = cacheDirectory;
    }

    @Override
    public void set(String key, Object data) {
        final Path cachePath = _cacheDirectory.resolve(key);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(cachePath))) {
            oos.writeObject(data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize and cache data", e);
        }
    }

    @Override
    public Object tryGetValue(String key) {
        final Path cachePath = _cacheDirectory.resolve(key);
        if (Files.exists(cachePath)) {
            try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(Files.newInputStream(cachePath))) {
                return ois.readObject();
            } catch (Exception e) {
                throw new RuntimeException("Failed to deserialize cached data", e);
            }
        }
        return null;
    }

    @Override
    public Iterable<String> getKeys(String filter) {
        try (Stream<Path> keysStream = Files.list(_cacheDirectory)) {
            if (filter != null && !filter.isEmpty()) {
                return keysStream.map(Path::getFileName).map(Path::toString).filter(fileName -> fileName.contains(filter)).collect(Collectors.toList());
            } else {
                return keysStream.map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to list cache keys", e);
        }
    }
}
