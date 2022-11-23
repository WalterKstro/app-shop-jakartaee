package com.walterkstro.models;
import static com.walterkstro.models.Currency.formating;
public class Product {
    private int id;
    private String description;
    private float price;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {}

    public Product(int id, String description, float price, Category category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(String description, float price, Category category) {
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
    public String formatCurrency() {
        return formating(this.price);
    }
}