package com.udacity.course3.reviews.repository.mongodb;

import com.udacity.course3.reviews.model.mongodb.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommentRepo extends MongoRepository<Comment,Integer> {

    Optional<Comment> findByIdAndComment(Integer id, String comment);
}
