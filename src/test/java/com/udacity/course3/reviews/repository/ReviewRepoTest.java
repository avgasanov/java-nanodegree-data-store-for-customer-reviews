package com.udacity.course3.reviews.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
//@DataJpaTest
public class ReviewRepoTest {

//    Review findByIdAndUsername(Integer id, String username);
//    List<Review> findByProductId(Integer productId);
    //public Review(Long id, String username, List<Comment> comments, Product product)

//    @Autowired
//    ReviewRepo reviewRepo;
//
//    @Autowired
//    ProductRepo productRepo;
//
//    Set<String> reviewsUsernameSet = new HashSet<>();
//    List<Product> products = new ArrayList<>();
//
//    @Before
//    public void setUp() {
//        reviewRepo.saveAll(getNReviewAndInitSet(10));
//        initProductsList();
//    }
//
//    @Test
//    public void verify_findAll() {
//        List<Review> reviews = reviewRepo.findAll();
//        Assert.assertEquals(10, reviews.size());
//        reviews.forEach((review -> {
//            Assert.assertNotNull(review.getId());
//            reviewsUsernameSet.remove(review.getUsername());
//        }));
//        Assert.assertTrue(reviewsUsernameSet.isEmpty());
//    }
//
//    @Test
//    public void verify_findByIdAndUsername() {
//        reviewRepo.findAll().forEach((review -> {
//            Optional<Review> reviewOptional =
//                    reviewRepo.findByIdAndUsername(review.getId(), review.getUsername());
//            Assert.assertTrue(reviewOptional.isPresent());
//            Assert.assertEquals(review, reviewOptional.get());
//        }));
//    }
//
//    @Test
//    public void verify_findByIdAndUsernameNonExistentId() {
//        Optional<Review> reviewOptional =
//                reviewRepo.findByIdAndUsername(11, "some-name");
//        Assert.assertFalse(reviewOptional.isPresent());
//    }
//
//    @Test
//    public void verify_findByProductId() {
//        products.forEach((product -> {
//            List<Review> reviews = reviewRepo.findByProductId(product.getId());
//            Assert.assertNotNull(reviews);
//            Assert.assertEquals(1, reviews.size());
//            reviewsUsernameSet.remove(reviews.get(0).getUsername());
//        }));
//        Assert.assertEquals(0, reviewsUsernameSet.size());
//    }
//
//    Review getReview(int n) {
//        Product product = new Product();
//        product.setName("some-name");
//        return new Review(null, n + "-username", new ArrayList<>(), product);
//    }
//
//    List<Review> getNReviewAndInitSet(int n) {
//        List<Review> reviews = new ArrayList<>();
//        for(int i = 0; i < n; i++) {
//            Review review = getReview(i);
//            reviews.add(review);
//            reviewsUsernameSet.add(review.getUsername());
//        }
//        return reviews;
//    }
//
//    private void initProductsList() {
//        reviewRepo.findAll().forEach((review -> {
//            products.add(review.getProduct());
//        }));
//    }

}
