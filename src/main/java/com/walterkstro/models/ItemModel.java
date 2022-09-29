package com.walterkstro.models;

import java.util.Objects;

import static com.walterkstro.models.Currency.formating;

public class ItemModel {
    private int quantity;
    private ProductModel product;
    private int id;
    private static int counter = 0;

    public ItemModel(ProductModel product) {
        this.id = ++ItemModel.counter;
        this.quantity = 1;
        this.product = product;
    }

    public ItemModel(int quantity, ProductModel product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemModel itemModel = (ItemModel) o;
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

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
    public float subTotal(){
        return quantity * product.getPrice();
    }

    public String formatCurrency() {
        return formating(this.subTotal());
    }
}
