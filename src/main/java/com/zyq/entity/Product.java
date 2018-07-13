package com.zyq.entity;

public class Product extends ProductKey {
    private String inventory;

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
}