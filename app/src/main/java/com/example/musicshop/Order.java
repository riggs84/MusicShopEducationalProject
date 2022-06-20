package com.example.musicshop;

public class Order {

    private String name;
    private int quantity;
    private double price;
    private String item;

    public Order(String name, int quantity, double price, String item) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.item = item;
    }
}
