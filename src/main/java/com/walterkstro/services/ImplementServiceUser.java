package com.walterkstro.services;

import com.walterkstro.exceptions.ExceptionService;
import com.walterkstro.interceptor.AnotationTransactionInterceptor;
import com.walterkstro.models.User;
import com.walterkstro.repository.IRepositoryUser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@RequestScoped
@AnotationTransactionInterceptor
public class ImplementServiceUser implements ServiceUser{
    @Inject
    private IRepositoryUser repository;

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
