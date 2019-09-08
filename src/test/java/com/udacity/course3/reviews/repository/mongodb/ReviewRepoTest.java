package com.udacity.course3.reviews.repository.mongodb;

import com.udacity.course3.reviews.model.mongodb.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


@ExtendWith(SpringExtension.class)
@DataMongoTest
@RunWith(SpringRunner.class)
public class ReviewRepoTest {

    @Autowired
    private ReviewRepo reviewRepo;

    @Test
    public void verify_findByIdAndUsername() {
        Integer id = 0;
        String username = "some name";
        Review reviewTest = new Review(id, username, null, null);
        reviewRepo.save(reviewTest);
        Review repoReview = reviewRepo.findByIdAndUsername(id, username).orElse(null);
        Assert.assertEquals(reviewTest, repoReview);
    }
}
