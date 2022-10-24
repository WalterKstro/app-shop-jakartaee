package com.walterkstro.repository;

import com.walterkstro.database.QueriesProduct;
import com.walterkstro.models.*;

import java.sql.*;
import java.util.*;

public class RepositoryProductModelImplementation implements Repository<ProductModel>{
    private Connection connection;

    public RepositoryProductModelImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ProductModel> all() throws SQLException {
        List<ProductModel> products = new ArrayList<>();
        try(var statement = connection.createStatement();
            var results = statement.executeQuery(QueriesProduct.SELECT_ALL.getQuery());){
            while( results.next() ){
                products.add( createInstance(results) );
            }
        }
        return products;
    }
    @Override
    public ProductModel find(Integer id) throws SQLException {
        ProductModel productFound = null;
        try(var statement = connection.prepareStatement(QueriesProduct.SELECT_WHERE.getQuery());){
            statement.setInt(1,id);
            try(var result = statement.executeQuery();){
                if( result.next() ){
                    productFound = createInstance(result);
                }
            }
        }
        return productFound;
    }
    private ProductModel createInstance (ResultSet result) throws SQLException {
        return new ProductModel(
                result.getInt(1),
                result.getString(2),
                result.getFloat(3),
                new CategoryModel( result.getString(4))
        );
    }

    @Override
    public void save(ProductModel productModel) throws SQLException {

    }

    @Override
    public void update(ProductModel productModel) throws SQLException {

    }
}
