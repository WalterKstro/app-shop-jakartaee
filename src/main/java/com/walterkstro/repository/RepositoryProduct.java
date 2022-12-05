package com.walterkstro.repository;

import com.walterkstro.database.QueriesProduct;
import com.walterkstro.models.*;

import java.sql.*;
import java.util.*;

public class RepositoryProduct implements Repository<Product>{
    private Connection connection;

    public RepositoryProduct(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> all() throws SQLException {
        var query = QueriesProduct.SELECT_ALL.getQuery();
        List<Product> products = new ArrayList<>();

        try(var statement = connection.createStatement();
            var results = statement.executeQuery(query);){
            while( results.next() ){
                products.add( createInstance(results) );
            }
        }
        return products;
    }
    @Override
    public Product find(Integer id) throws SQLException {
        var query = QueriesProduct.SELECT_WHERE.getQuery();
        Product productFounded = null;

        try(var statement = connection.prepareStatement(query);){
            statement.setInt(1,id);
            try(var result = statement.executeQuery();){
                if( result.next() ){
                    productFounded = createInstance(result);
                }
            }
        }
        return productFounded;
    }

    @Override
    public Product createInstance(ResultSet result) throws SQLException {
        Product product = new Product();
        product.setId( result.getInt(1) );
        product.setDescription( result.getString(2) );
        product.setPrice( result.getFloat(3) );
        try{
            product.setCategory( new Category( result.getInt(5), result.getString(4)));
        }catch (SQLException sqe) {
            product.setCategory( new Category( result.getString(4)));
        }

        return product;
    }

    @Override
    public void save(Product product) throws SQLException {
        var query = QueriesProduct.INSERT_SIMPLE.getQuery();
        if( product.getId() != 0){
            query = QueriesProduct.UPDATE_SIMPLE.getQuery();
        }

        try( var statement = connection.prepareStatement(query)){

            statement.setString(1,product.getDescription());
            statement.setFloat(2,product.getPrice());
            statement.setInt(3,product.getCategory().getId());

            if( product.getId() != 0 ){
                statement.setInt( 4, product.getId() );
            }
            statement.executeUpdate();
        }
    }

    @Override
    public int delete(Product product) throws SQLException {
        int rows = 0;
        var query = QueriesProduct.DELETE_SIMPLE.getQuery();
        try ( var statement = connection.prepareStatement(query) ){
            statement.setInt(1, product.getId());
            rows = statement.executeUpdate();
        }
        return rows;
    }

}
