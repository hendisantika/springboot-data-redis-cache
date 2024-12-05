package com.hendisantika.springbootdatarediscache.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/12/24
 * Time: 00.43
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final HashOperations hashOperations;

}