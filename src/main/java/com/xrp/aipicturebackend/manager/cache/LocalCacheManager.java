package com.xrp.aipicturebackend.manager.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class LocalCacheManager implements CacheManager {
    private final Cache<String,String> LOCAL_CACHE =
                    Caffeine.newBuilder().initialCapacity(1024).maximumSize(10000l)
                            .expireAfterWrite(5L, TimeUnit.MINUTES)
                            .build();

    @Override
    public String get(String key) {
        return LOCAL_CACHE.getIfPresent(key);
    }

    @Override
    public void set(String key, String value, int expireTime) {
        LOCAL_CACHE.put(key, value);
    }
}
