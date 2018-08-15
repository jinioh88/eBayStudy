package com.example.myshop;

import com.example.myshop.domain.Product;
import com.example.myshop.repository.ProductRepository;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;


//    @Before
//    public void init() throws Exception {
//        Product product1 = new Product();
//        product1.setPName("p1");
//        Product product2 = new Product();
//        product1.setPName("p2");
//        Product product3 = new Product();
//        product1.setPName("p3");
//
//
//        repository.save(product1);
//        repository.save(product2);
//        repository.save(product3);
//    }

    @Test
    public void test1() {
        Product product = new Product();
        product.setPName("pp");
        repository.save(product);
    }
}
