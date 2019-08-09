package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review,Integer> {

    Optional<Review> findByIdAndUsername(Integer id, String username);
    List<Review> findByProductId(Integer productId);
}
