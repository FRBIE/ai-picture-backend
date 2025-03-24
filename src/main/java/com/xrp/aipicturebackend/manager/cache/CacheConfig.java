package com.xrp.aipicturebackend.manager.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CacheConfig {

    @Bean
    @Primary
    public CacheManager redisCacheManager() {
        return new RedisCacheManager(); // 默认使用Redis缓存
    }

    @Bean
    public CacheManager localCacheManager() {
        return new LocalCacheManager(); // 本地缓存
    }
}
