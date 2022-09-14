package com.walterkstro.services;

import com.walterkstro.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> getList();
    void fillList();
    Optional<ProductModel> findById(int id);
}
