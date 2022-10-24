package com.walterkstro.models;
import static com.walterkstro.models.Currency.formating;
public class ProductModel{
    private int id;
    private String description;
    private float price;
    private CategoryModel category;

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public ProductModel() {}

    public ProductModel(int id, String description, float price, CategoryModel category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public ProductModel(int id, String description) {
        this.id = id;
        this.description = description;
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