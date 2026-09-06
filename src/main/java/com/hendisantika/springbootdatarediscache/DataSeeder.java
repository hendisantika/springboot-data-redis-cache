package com.hendisantika.springbootdatarediscache;

import com.hendisantika.springbootdatarediscache.entity.Product;
import com.hendisantika.springbootdatarediscache.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-data-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/20
 * Time: 05.02
 */
@Log4j2
@Component
@Profile("!test")
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {
        productDao.save(new Product(1, "Bratislava", 1, 432000));
        productDao.save(new Product(2, "Konohagakure", 2, 432000));
        productDao.save(new Product(3, "Kirigakure", 3, 432000));
        productDao.save(new Product(4, "Sunagakure", 4, 432000));
        productDao.save(new Product(5, "Iwagakure", 5, 432000));
        productDao.save(new Product(5, "Kumogakure", 6, 432000));

        productDao.findAll().forEach((product) -> {
            log.info("{}", product);
        });
    }
}
