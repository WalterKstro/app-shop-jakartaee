package com.walterkstro.services;

import com.walterkstro.models.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductImplement implements ProductService{
    List<ProductModel> listado;

    public ProductImplement() {
        this.listado = new ArrayList<>();
        this.fillList();
    }
    @Override
    public List<ProductModel> getList() {
        return listado;
    }

    @Override
    public void fillList() {
        listado.add(new ProductModel(568,"Smartv Samsung",1750.55f,"Entretenimiento"));
        listado.add(new ProductModel(985,"IPhone 10X Pro",12750.55f,"Entretenimiento"));
        listado.add(new ProductModel(156,"Estufa Mabe",1350.55f,"Electrodomestico"));
        listado.add(new ProductModel(896,"Portatil HP Compaq",7550.55f,"Trabajo"));
    }

    @Override
    public Optional<ProductModel> findById(int id) {
        return listado.stream()
                .filter(product -> Integer.valueOf(product.getId()).equals( Integer.valueOf(id) ))
                .findFirst();
    }
}
