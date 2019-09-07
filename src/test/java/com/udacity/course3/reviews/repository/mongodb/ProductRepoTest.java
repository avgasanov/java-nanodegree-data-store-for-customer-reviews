package com.udacity.course3.reviews.repository.mongodb;

import com.udacity.course3.reviews.model.mongodb.Product;
import com.udacity.course3.reviews.model.mongodb.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@RunWith(SpringRunner.class)
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    public void verify_findByIdAndName() {
        String name = "some name";
        Integer id = 0;
        Product testProduct = new Product(id, name, new ArrayList<Review>());
        productRepo.save(testProduct);
        Product repoProduct = productRepo.findByIdAndName(id, name).orElse(null);
        Assert.assertEquals(testProduct, repoProduct);
    }

}
