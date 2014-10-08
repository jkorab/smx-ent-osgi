package fancyfoods.cheese;

import fancyfoods.food.Food;

// TODO not yet implemented
class Cheese implements Food {
    @Override
    public String getName() {
        return "Cheese";
    }

    @Override
    public double getPrice() {
        return 1.49;
    }

    @Override
    public int getQuantityInStock() {
        return 20;
    }
}
