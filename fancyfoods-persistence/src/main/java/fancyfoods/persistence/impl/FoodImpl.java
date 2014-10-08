package fancyfoods.persistence.impl;

import fancyfoods.food.Food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "FOOD")
public class FoodImpl implements Food {
    @Id
    private String name;
    private double price;
    private int quantity;

    // used by JPA
    public FoodImpl() {}

    // convenience constructor
    public FoodImpl(String name, double price, int quantity) {
        this();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantityInStock() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantity) {
        this.quantity = quantity;
    }
}
