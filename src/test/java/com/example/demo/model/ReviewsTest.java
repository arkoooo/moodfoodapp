package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReviewsTest {

    Reviews reviews;

    @Before
    public void setUp() {reviews = new Reviews();}

    @Test
    public void getId(){
        int idValue = 10;
        reviews.setReviewId(idValue);
        assertEquals(idValue, reviews.getReviewId());
    }

    @Test
    public void getUser(){
        int user = 16;
        reviews.setReviewUser(user);
        assertEquals(user, reviews.getReviewUser());
    }

    @Test
    public void getRestaurant(){
        int restaurant = 19;
        reviews.setReviewRestaurant(restaurant);
        assertEquals(restaurant, reviews.getReviewRestaurant());
    }
    @Test
    public void getText(){
        String text  = "text of review";
        reviews.setReviewText(text);
        assertEquals(text, reviews.getReviewText());
    }

    @Test
    public void getValue(){
        int value = 39;
        reviews.setReviewValue(value);
        assertEquals(value, reviews.getReviewValue());
    }


}
