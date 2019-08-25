package com.udacity.course3.reviews.repository.mongodb;

import com.udacity.course3.reviews.model.mongodb.Product;
import com.udacity.course3.reviews.model.mongodb.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends MongoRepository<Product,Integer> {

    Optional<Product> findByIdAndName(Integer id, String name);
    List<Review> findReviewById(Integer id);
}
