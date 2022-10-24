package com.walterkstro.services;

import com.walterkstro.CustomExceptions.ExceptionService;
import com.walterkstro.models.ProductModel;
import com.walterkstro.repository.RepositoryProductModelImplementation;

import java.sql.*;
import java.util.*;

public class ServiceProductModel implements ProductService{
    private RepositoryProductModelImplementation repository;

    public ServiceProductModel(Connection connection) {
        repository = new RepositoryProductModelImplementation(connection);
    }

    @Override
    public List<ProductModel> getList(){
        try {
            return repository.all();
        } catch (SQLException e) {
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
    }

    @Override
    public Optional<ProductModel> findById(Integer id){
        ProductModel result = null;
        try {
            result = repository.find(id);
        } catch (SQLException e) {
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
        return Optional.ofNullable(result);
    }
}
