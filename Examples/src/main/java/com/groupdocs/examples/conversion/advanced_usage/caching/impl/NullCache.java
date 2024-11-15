package com.groupdocs.examples.conversion.advanced_usage.caching.impl;

import com.groupdocs.conversion.caching.ICache;

public class NullCache implements ICache {
    @Override
    public void set(String s, Object o) {

    }

    @Override
    public Object tryGetValue(String s) {
        return null;
    }

    @Override
    public Iterable<String> getKeys(String s) {
        return null;
    }
}
