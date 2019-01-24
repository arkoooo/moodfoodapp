package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;
    private int reviewUser;
    private int reviewRestaurant;
    private String reviewText;
    private int reviewValue;

    @ManyToMany
    @JoinTable(name = "restaurants_reviews",
            joinColumns = @JoinColumn(name= "reviews_reviewid"),
            inverseJoinColumns = @JoinColumn(name = "restaurants_restaurantid"))
    private Set<Restaurants> restaurants = new HashSet<>();

    public Reviews(){
    }

    public Reviews(int reviewUser, int reviewRestaurant, String reviewText, int reviewValue) {
        this.reviewUser = reviewUser;
        this.reviewRestaurant = reviewRestaurant;
        this.reviewText = reviewText;
        this.reviewValue = reviewValue;

    }

    public Reviews(int reviewUser, int reviewRestaurant, String reviewText, int reviewValue, Set<Restaurants> restaurants) {
        this.reviewUser = reviewUser;
        this.reviewRestaurant = reviewRestaurant;
        this.reviewText = reviewText;
        this.reviewValue = reviewValue;
        this.restaurants = restaurants;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewUser() {
        return reviewUser;
    }

    public void setReviewUser(int reviewUser) {
        this.reviewUser = reviewUser;
    }

    public int getReviewRestaurant() {
        return reviewRestaurant;
    }

    public void setReviewRestaurant(int reviewRestaurant) {
        this.reviewRestaurant = reviewRestaurant;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(int reviewValue) {
        this.reviewValue = reviewValue;
    }

    public Set<Restaurants> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurants> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return reviewId == reviews.reviewId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(reviewId);
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "reviewId=" + reviewId +
                ", reviewUser=" + reviewUser +
                ", reviewRestaurant=" + reviewRestaurant +
                ", reviewText='" + reviewText + '\'' +
                ", reviewValue=" + reviewValue +
                ", restaurants=" + restaurants +
                '}';
    }
}
