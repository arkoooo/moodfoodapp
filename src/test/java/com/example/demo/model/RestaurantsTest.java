package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantsTest {

    Restaurants restaurants;

    @Before
    public void setUp() {restaurants = new Restaurants(); }

    @Test
    public void getRestaurantId(){
        int restaurantIdValue = 41;
        restaurants.setRestaurantId(restaurantIdValue);
        assertEquals(restaurantIdValue, restaurants.getRestaurantId());
    }

    @Test
    public void getRestaurantName(){
        String restaurantName = "restaurantName";
        restaurants.setRestaurantName(restaurantName);
        assertEquals(restaurantName, restaurants.getRestaurantName());
    }

    @Test
    public void getRestaurantLocation(){
        String restaurantLocation = "restaurantLocation";
        restaurants.setRestaurantLocation(restaurantLocation);
        assertEquals(restaurantLocation, restaurants.getRestaurantLocation());
    }

    @Test
    public void getRestaurantDescription(){
        String restaurantDescription = "restaurantDescription";
        restaurants.setRestaurantDescription(restaurantDescription);
        assertEquals(restaurantDescription, restaurants.getRestaurantDescription());
    }

    @Test
    public void getRestaurantPhoto(){
        String restaurantPhoto = "restaurantPhoto";
        restaurants.setRestaurantPhoto(restaurantPhoto);
        assertEquals(restaurantPhoto, restaurants.getRestaurantPhoto());
    }
}
