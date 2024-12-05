package com.hendisantika.springbootdatarediscache.repository;

import com.hendisantika.springbootdatarediscache.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

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

    public void create(User user) {
        hashOperations.put("USER", user.getUserId(), user);
        log.info("User with ID {} saved", user.getUserId());
    }

    public User get(String userId) {
        return (User) hashOperations.get("USER", userId);
    }

    public Map<String, User> getAll() {
        return hashOperations.entries("USER");
    }

    public void update(User user) {
        hashOperations.put("USER", user.getUserId(), user);
        log.info("User with ID {} updated", user.getUserId());
    }
}
