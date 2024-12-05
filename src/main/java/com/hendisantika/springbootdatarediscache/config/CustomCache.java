package com.hendisantika.springbootdatarediscache.config;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/12/24
 * Time: 00.58
 * To change this template use File | Settings | File Templates.
 */
public class CustomCache extends RedisCache {

    protected CustomCache(String name, RedisCacheWriter cacheWriter, RedisCacheConfiguration cacheConfig) {
        super(name, cacheWriter, cacheConfig);
    }
}
