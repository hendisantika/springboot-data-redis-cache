package com.hendisantika.springbootdatarediscache.repository;

import com.hendisantika.springbootdatarediscache.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id) {
        System.out.println("called findProductById() from DB");
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }


    public String deleteProduct(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "product removed !!";
    }
}