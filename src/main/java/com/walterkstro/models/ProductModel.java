package com.walterkstro.models;

public class ProductModel {
    private int id;
    private String description;
    private float price;
    private String type;
    private static int counter = 0;

    public ProductModel() {
        this.id = ++ProductModel.counter;
    }

    public ProductModel(String description, float price, String type) {
        this();
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}