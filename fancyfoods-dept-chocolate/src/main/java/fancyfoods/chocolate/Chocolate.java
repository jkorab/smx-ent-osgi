package fancyfoods.chocolate;

import fancyfoods.food.Food;

class Chocolate implements Food {
    @Override
    public String getName() {
        return "Chocolate";
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
