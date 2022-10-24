package com.walterkstro.services;

import com.walterkstro.models.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductImplement implements ProductService{
    List<ProductModel> listado;

    public ProductImplement() {
        this.listado = new ArrayList<>();
    }
    @Override
    public List<ProductModel> getList() {
        return listado;
    }

    @Override
    public Optional<ProductModel> findById(Integer id) {
        return listado.stream()
                .filter(product -> Integer.valueOf(product.getId()).equals( Integer.valueOf(id) ))
                .findFirst();
    }
}
