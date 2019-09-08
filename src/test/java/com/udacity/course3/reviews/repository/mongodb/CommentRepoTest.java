package com.udacity.course3.reviews.repository.mongodb;

import com.udacity.course3.reviews.model.mongodb.Comment;
import com.udacity.course3.reviews.model.mongodb.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@RunWith(SpringRunner.class)
public class CommentRepoTest {

    @Autowired
    public CommentRepo commentRepo;

    @Test
    public void verify_findByIdAndComment() {
        Comment testComment = new Comment(0, "Some comment", LocalDateTime.now(), null);
        commentRepo.save(testComment);
        Comment repoComment = commentRepo
                .findByIdAndComment(testComment.getId(), testComment.getComment())
                .orElse(null);
        Assert.assertEquals(testComment, repoComment);
    }

}
