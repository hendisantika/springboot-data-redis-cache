package com.hendisantika.springbootdatarediscache.controller;

import com.hendisantika.springbootdatarediscache.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/12/24
 * Time: 00.59
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final CacheService redisCacheService;

    @GetMapping("/get/data")
    public String getData() {
        return redisCacheService.getData();
    }

    @GetMapping("/get/datattl/10")
    public String getData10TTL() {
        return redisCacheService.get10MinTTL();
    }

    @GetMapping("/get/datattl/20")
    public String getData20TTL() {
        return redisCacheService.get20MinTTL();
    }
}
