package com.walterkstro.services;

import com.walterkstro.exceptions.ExceptionService;
import com.walterkstro.models.Product;
import com.walterkstro.repository.*;

import java.sql.*;
import java.util.*;

public class ProductService implements Service<Product> {
    private Repository<Product> repository;

    public ProductService(Connection connection) {
        repository = new RepositoryProduct(connection);
    }

    @Override
    public List<Product> get(){
        try {
            return repository.all();
        } catch (SQLException e) {
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
    }

    @Override
    public Optional<Product> findById(Integer id){
        Product result = null;
        try {
            result = repository.find(id);
        } catch (SQLException e) {
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void save(Product product) {
        try {
            repository.save(product);
        } catch (SQLException e) {
            throw new ExceptionService(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void delete(int id) {
        try{
            repository.delete(new Product(id));
        } catch (SQLException e) {
            throw new ExceptionService(e.getMessage(),e.getCause());
        }
    }
}
