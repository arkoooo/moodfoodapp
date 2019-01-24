package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private String restaurantDescription;
    private String restaurantPhoto;

    @ManyToMany(mappedBy = "restaurants")
    private Set<Reviews> reviews = new HashSet<>();

    public Restaurants(){
    }

    public Restaurants(String restaurantName, String restaurantLocation, String restaurantDescription, String restaurantPhoto) {
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantDescription = restaurantDescription;
        this.restaurantPhoto = restaurantPhoto;
    }

    public Restaurants(String restaurantName, String restaurantLocation, String restaurantDescription, String restaurantPhoto, Set<Reviews> reviews) {
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantDescription = restaurantDescription;
        this.restaurantPhoto = restaurantPhoto;
        this.reviews = reviews;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public String getRestaurantPhoto() {
        return restaurantPhoto;
    }

    public void setRestaurantPhoto(String restaurantPhoto) {
        this.restaurantPhoto = restaurantPhoto;
    }

    public Set<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurants that = (Restaurants) o;
        return restaurantId == that.restaurantId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId);
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                ", restaurantDescription='" + restaurantDescription + '\'' +
                ", restaurantPhoto='" + restaurantPhoto + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
