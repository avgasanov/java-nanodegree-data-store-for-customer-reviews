package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;

    Set<String> productNamesSet = new HashSet<>();

    @Before
    public void setUp() {
        productRepo.saveAll(getNProductAndInitSet(10));
    }

    @Test
    public void verify_findAll() {
        List<Product> products = productRepo.findAll();
        Assert.assertEquals(10, products.size());
        products.forEach((product -> {
            Assert.assertNotNull(product.getId());
            productNamesSet.remove(product.getName());
        }));
        Assert.assertTrue(productNamesSet.isEmpty());
    }

    @Test
    public void verify_findByIdAndName() {
        List<Product> products = productRepo.findAll();
        products.forEach((product -> {
            Optional<Product> productOptional =
                    productRepo.findByIdAndName(product.getId(), product.getName());
            Assert.assertTrue(productOptional.isPresent());
            Assert.assertEquals(product, productOptional.get());
        }));
    }

    private Product getProduct(int n) {
        return new Product(null, n + "-product", new ArrayList<>());
    }

    private List<Product> getNProductAndInitSet(int n) {
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Product product = getProduct(i);
            productNamesSet.add(product.getName());
            products.add(product);
        }
        return products;
    }
}
