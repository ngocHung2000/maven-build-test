package com.vn;

import com.vn.entity.Product;
import com.vn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Autowired
    ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Product> lst = new ArrayList<>();
        lst.add(new Product(null,"Kem",new BigDecimal("25000"),"Kem cay"));
        lst.add(new Product(null,"Banh",new BigDecimal("30000"),"Banh ngot"));
        lst.add(new Product(null,"Keo",new BigDecimal("55000"),"Keo keo"));

        productRepository.saveAll(lst);
    }
}
