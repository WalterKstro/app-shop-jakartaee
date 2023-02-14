package com.walterkstro.repository;

import com.walterkstro.database.QueriesUser;
import com.walterkstro.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ImplementRepositoryUser implements IRepositoryUser{

    private Connection connection;

    public ImplementRepositoryUser(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> all() throws SQLException {
        return null;
    }

    @Override
    public User find(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void save(User user) throws SQLException {

    }

    @Override
    public int delete(User user) throws SQLException {
        return 0;
    }

    @Override
    public User createInstance(ResultSet result) throws SQLException {
        return new User( result.getString(1), result.getString(2) );
    }

    @Override
    public User findByEmail(User user) throws SQLException {
        var query = QueriesUser.SELECT_WHERE.getQuery();
        User userFind = null;
        try( var statement = connection.prepareStatement(query) ){
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPassword());
            try( var result = statement.executeQuery() ){
                if( result.next() ) {
                    userFind = createInstance( result );
                }
            }
        }
        return userFind;
    }
}
