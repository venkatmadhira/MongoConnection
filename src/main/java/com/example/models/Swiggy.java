package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Swiggy {
    private List<Restaurant> restaurants;

    public Swiggy() {
        this.restaurants = new ArrayList<>();
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }
}
