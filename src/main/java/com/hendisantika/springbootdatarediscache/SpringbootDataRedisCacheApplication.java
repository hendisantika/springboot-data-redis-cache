package com.hendisantika.springbootdatarediscache;

import com.hendisantika.springbootdatarediscache.entity.Product;
import com.hendisantika.springbootdatarediscache.repository.ProductDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class SpringbootDataRedisCacheApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataRedisCacheApplication.class, args);
    }

    @Autowired
    private ProductDao productDao;

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
