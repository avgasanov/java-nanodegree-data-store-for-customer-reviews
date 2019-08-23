package com.udacity.course3.reviews.repository.mongodb;

import com.udacity.course3.reviews.model.mongodb.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends MongoRepository<Review,Integer> {

    Optional<Review> findByIdAndUsername(Integer id, String username);
}
