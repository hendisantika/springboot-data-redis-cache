package com.hendisantika.springbootdatarediscache.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        log.warn("CustomCacheResolver resolveCaches");
        if (context != null && context.getOperation() != null && (context.getOperation().getCacheNames() != null
                && !context.getOperation().getCacheNames().isEmpty())) {
            Collection<CustomCache> caches = new HashSet<>();

            Set<String> cacheNames = context.getOperation().getCacheNames().stream().collect(Collectors.toSet());

            cacheNames.forEach(cacheName -> {

                Cache cache = cacheManager.getCache(cacheName);
                CustomCache customCache = cacheWithCustomTTL(cacheName, cache);
                caches.add(customCache);
            });
            return caches;

        }
        // this should not reach here
        log.warn("CustomCacheResolver context is empty");
        return Collections.emptyList();
    }
}
