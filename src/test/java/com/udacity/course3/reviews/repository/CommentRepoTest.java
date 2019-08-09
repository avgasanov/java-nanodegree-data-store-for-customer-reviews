package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepoTest {

    @Autowired
    CommentRepo commentRepo;

    Set<String> commentsSet = new HashSet<>();

    @Before
    public void setUp() {
        commentRepo.saveAll(getNCommentsAndInitSet(10));
    }

    @Test
    public void verify_findAll() {
        System.out.println("comments set: " + commentsSet);
        List<Comment> comments = commentRepo.findAll();
        Assert.assertEquals(10, comments.size());
        comments.forEach((comment -> {
            Assert.assertNotNull(comment.getId());
            commentsSet.remove(comment.getComment());
            System.out.println("removing from comments set: " + comment.getComment());
        }));
        System.out.println("comments set: " + commentsSet);
        Assert.assertTrue(commentsSet.isEmpty());
    }

    @Test
    public void verify_findByNameAndId() {
        List<Comment> comments = commentRepo.findAll();
        comments.forEach((comment) -> {
            Optional<Comment> commentOptional =
                    commentRepo.findByIdAndComment(comment.getId(), comment.getComment());
            Assert.assertTrue(commentOptional.isPresent());
            Assert.assertEquals(commentOptional.get(), comment);
        });
    }

    private Comment getComment(int n) {
        return new Comment(null, n + "-comment", LocalDateTime.now(), new Review());
    }

    private List<Comment> getNCommentsAndInitSet(int n) {
        List<Comment> comments = new ArrayList<Comment>();
        for(int i = 0; i < n; i++) {
            Comment comment = getComment(i);
            comments.add(comment);
            commentsSet.add(comment.getComment());
        }
        return comments;
    }

}
