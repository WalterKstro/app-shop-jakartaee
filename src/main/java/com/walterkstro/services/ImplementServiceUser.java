package com.walterkstro.services;

import com.walterkstro.exceptions.ExceptionService;
import com.walterkstro.models.User;
import com.walterkstro.repository.ImplementRepositoryUser;
import com.walterkstro.repository.RepositoryUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ImplementServiceUser implements ServiceUser{
    private RepositoryUser repository;

    public ImplementServiceUser(Connection connection) {
        repository = new ImplementRepositoryUser(connection);
    }

    @Override
    public List<User> get() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Optional<User> authentication(User u) {
        User user = null;
        try{
            user = repository.findByEmail(u);
        }catch (SQLException e){
            // throw for catch in filter
            throw new ExceptionService( e.getMessage(), e.getCause() );
        }
        return Optional.ofNullable( user );
    }
}
