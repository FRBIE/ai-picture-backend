package com.xrp.aipicturebackend.manager.cache;

public interface CacheManager {
    String get(String key);
    void set(String key, String value,int expireTime);
}
