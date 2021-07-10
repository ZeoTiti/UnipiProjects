package com.example.polit.onlineshop;

import java.util.UUID;

public class Mobile {
    private String ID;
    private String name;
    private double price;

    public Mobile() {}

    public Mobile(String name, double price) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
