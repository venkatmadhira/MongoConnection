package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String address;
    private List<Dish> dishes;

    public Restaurant(String address) {
        this.address = address;
        this.dishes = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }
}
