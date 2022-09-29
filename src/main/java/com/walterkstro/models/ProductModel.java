package com.walterkstro.models;
import static com.walterkstro.models.Currency.formating;
public class ProductModel{
    private int id;
    private String description;
    private float price;
    private String type;

    public ProductModel(int id,String description, float price, String type) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.type = type;
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
    public String formatCurrency() {
        return formating(this.price);
    }
}