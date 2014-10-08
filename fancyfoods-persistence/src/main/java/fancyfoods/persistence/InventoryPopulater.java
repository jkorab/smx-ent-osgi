package fancyfoods.persistence;

import fancyfoods.food.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryPopulater {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Inventory inventory;

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void populate() {
        boolean isInventoryPopulated = (inventory.getFoodCount() > 0);

        if (!isInventoryPopulated) {
            log.info("Creating fancyfoods inventory");
            inventory.createFood("Blue cheese", 3.45, 10);
            inventory.createFood("Wensleydale cheese", 1.81, 15);
            inventory.createFood("Normal chocolates", 6.99, 8);
        }
    }
}
