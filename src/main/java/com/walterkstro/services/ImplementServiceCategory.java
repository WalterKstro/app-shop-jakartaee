package com.walterkstro.services;

import com.walterkstro.exceptions.ExceptionService;
import com.walterkstro.models.Category;
import com.walterkstro.repository.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.*;

@RequestScoped
public class ImplementServiceCategory implements ServiceCrud<Category> {
    @Inject
    private IRepositoryCrud<Category>repository;

    @Override
    public List<Category> get() {
        try{
            return repository.all();
        } catch (SQLException e) {
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
    }

    @Override
    public Optional<Category> findById(Integer id) {
        Category category = null;
        try{
            category = repository.find(id);
        } catch (SQLException e) {
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
        return Optional.ofNullable(category);
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
