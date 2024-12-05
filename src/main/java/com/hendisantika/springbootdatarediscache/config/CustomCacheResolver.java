package com.hendisantika.springbootdatarediscache.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/12/24
 * Time: 00.56
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CustomCacheResolver implements CacheResolver {

    private static final int DEFAULT_TTL = 30;

    private final CacheManager cacheManager;

    private final Map<String, String> mapNameConfig = new HashMap<>();

    @PostConstruct
    public void init() {
        mapNameConfig.put("10m-", "10");
        mapNameConfig.put("20m-", "20");
    }
}
