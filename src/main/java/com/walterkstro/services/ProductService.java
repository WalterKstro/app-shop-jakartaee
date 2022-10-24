package com.walterkstro.services;

import com.walterkstro.models.ProductModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductService{
    List<ProductModel> getList();

    Optional<ProductModel> findById(Integer id);
}
