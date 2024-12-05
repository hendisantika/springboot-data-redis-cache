package com.hendisantika.springbootdatarediscache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/12/24
 * Time: 01.01
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class CacheService {
    //cacheResolver - must point to our customCacheResolver component
    @Cacheable(value = "10m-cache-ttl", key = "'somename'", cacheResolver = "customCacheResolver")
    public String get10MinTTL() {
        try {
            log.warn("Thread sleeping for 5 seconds");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.warn("Thread sleep interrupted");
        }
        return "Hello World from 10m";
    }

    //cacheResolver - must point to our customCacheResolver component
    @Cacheable(value = "20m-cache-ttl", key = "'somename'", cacheResolver = "customCacheResolver")
    public String get20MinTTL() {
        try {
            log.warn("Thread sleeping for 5 seconds");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.warn("Thread sleep interrupted");
        }
        return "Hello World from 20m";
    }
}
