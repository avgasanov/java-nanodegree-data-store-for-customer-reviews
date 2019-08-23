package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.model.mongodb.Product;
import com.udacity.course3.reviews.model.mongodb.Review;
import com.udacity.course3.reviews.repository.mongodb.ProductRepo;
import com.udacity.course3.reviews.repository.mongodb.ReviewRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    private final ProductRepo productRepo;
    private final ReviewRepo reviewRepo;

    public ReviewsController(ProductRepo productRepo, ReviewRepo reviewRepo) {
        this.productRepo = productRepo;
        this.reviewRepo = reviewRepo;
    }

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId,
                                                    @RequestBody Review review) {
        Optional<Product> productOptional = productRepo.findById(productId);
        return productOptional
                .map((product -> {
                        product.getReviews().add(review);
                        return new ResponseEntity<>(product, HttpStatus.OK);
                })).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(
                productRepo.findReviewById(productId), HttpStatus.OK);
    }
}