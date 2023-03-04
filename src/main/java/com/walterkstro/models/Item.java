package com.walterkstro.models;

import java.util.Objects;

import static com.walterkstro.models.Currency.formating;


public class Item {
    private int quantity;
    private Product product;
    private int id;


    public Item(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item itemModel = (Item) o;
        return Objects.equals(product.getId(), itemModel.getProduct().getId())
                && Objects.equals(product.getDescription(), itemModel.product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public float subTotal(){
        return quantity * product.getPrice();
    }

    public String formatCurrency() {
        return formating(this.subTotal());
    }
}
