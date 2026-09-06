package com.hendisantika.springbootdatarediscache.repository;

import com.hendisantika.springbootdatarediscache.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/20
 * Time: 05.16
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDao {

    public static final String HASH_KEY = "Product";

    private final RedisTemplate redisTemplate;

    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id) {
        log.info("called findProductById() from DB");
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }


    public String deleteProduct(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "product removed !!";
    }
}
