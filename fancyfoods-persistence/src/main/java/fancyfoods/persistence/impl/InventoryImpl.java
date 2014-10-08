package fancyfoods.persistence.impl;

import fancyfoods.food.Food;
import fancyfoods.food.Inventory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class InventoryImpl implements Inventory {
    private EntityManager entityManager;

    // this setter will be called as a result of the <jpa:context/> tag
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Food getFood(String name) {
        return entityManager.find(FoodImpl.class, name);
    }

    @Override
    public void createFood(String name, double price, int quantity) {
        FoodImpl food = new FoodImpl(name, price, quantity);
        entityManager.persist(food);
    }

    @Override
    public List<Food> getFoodWhoseNameContains(String name, int maxResults) {
        String query = "SELECT f from FOOD f WHERE f.name LIKE '%" + name + "%' order by f.quantity DESC";
        Query q = entityManager.createQuery(query);
        q.setMaxResults(maxResults);
        return q.getResultList();
    }


    @Override
    public int getFoodCount() {
        Query q = entityManager.createQuery("SELECT count(f) from FOOD f");
        Number count = (Number) q.getSingleResult();
        return count.intValue();
    }

    @Override
    public int removeStock(String name, int quantity) {
        return 0;
    }

}
