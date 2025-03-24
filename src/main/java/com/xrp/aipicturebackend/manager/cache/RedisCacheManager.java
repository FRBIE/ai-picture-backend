package com.xrp.aipicturebackend.manager.cache;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

//@Service
public class RedisCacheManager implements CacheManager {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String get(String key) {
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        return valueOps.get(key);
    }

    @Override
    public void set(String key, String value, int expireTime) {
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        valueOps.set(key, value, expireTime, TimeUnit.SECONDS);
    }
}
