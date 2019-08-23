package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.model.mongodb.Comment;
import com.udacity.course3.reviews.model.mongodb.Review;
import com.udacity.course3.reviews.repository.mongodb.CommentRepo;
import com.udacity.course3.reviews.repository.mongodb.ReviewRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // TODO: Wire needed JPA repositories here
    private final ReviewRepo reviewRepo;
    private final CommentRepo commentRepo;

    public CommentsController(ReviewRepo reviewRepo,
                              CommentRepo commentRepo) {
        this.reviewRepo = reviewRepo;
        this.commentRepo = commentRepo;
    }

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId,
                                                    @RequestBody Comment comment) {
        Optional<Review> review = reviewRepo.findById(reviewId);
        if(!review.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Comment savedComment = commentRepo.save(comment);
        return new ResponseEntity<Comment>(savedComment, HttpStatus.OK);
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Optional<Review> review = reviewRepo.findById(reviewId);
        return review
                .map(value -> new ResponseEntity<>(value.getComments(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}