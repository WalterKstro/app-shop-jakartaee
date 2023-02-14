package com.walterkstro.services;

import com.walterkstro.exceptions.ExceptionService;
import com.walterkstro.models.Category;
import com.walterkstro.repository.*;

import java.sql.*;
import java.util.*;

public class ImplementServiceCategory implements Service<Category>{
    private IRepositoryCrud<Category>repository;

    public ImplementServiceCategory(Connection connection) {
        repository = new ImplementRepositoryCategory(connection);
    }

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
