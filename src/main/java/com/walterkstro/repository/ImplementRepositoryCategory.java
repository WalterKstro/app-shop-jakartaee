package com.walterkstro.repository;

import com.walterkstro.database.QueriesCategory;
import com.walterkstro.models.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.*;
import java.util.*;

@ApplicationScoped
public class ImplementRepositoryCategory implements IRepositoryCrud<Category>{
    @Inject
    @Named("conn")
    private Connection connection;

    @Override
    public List<Category> all() throws SQLException {
        var query = QueriesCategory.SELECT_ALL.getQuery();
        List<Category> categories = new ArrayList<>();

        try(var statement = connection.createStatement();
            var results = statement.executeQuery(query);){
            while( results.next() ){
                categories.add( createInstance(results) );
            }
        }
        return categories;
    }


    @Override
    public Category find(Integer id) throws SQLException {
        var query = QueriesCategory.SELECT_WHERE.getQuery();
        Category categoryFounded = null;
        try( var statement = connection.prepareStatement(query); ){
            statement.setInt(1,id);
            try(var result = statement.executeQuery();){
                if( result.next() ){
                    categoryFounded = createInstance(result);
                }
            }
        }
        return categoryFounded;
    }

    @Override
    public Category createInstance(ResultSet result) throws SQLException {
        return new Category(result.getInt(1),result.getString(2));
    }

    @Override
    public void save(Category category) throws SQLException {

    }

    @Override
    public int delete(Category category) throws SQLException {
        return 0;
    }
}
