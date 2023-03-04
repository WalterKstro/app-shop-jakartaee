package com.walterkstro.repository;

import com.walterkstro.models.User;

import java.sql.SQLException;

public interface IRepositoryUser extends IRepositoryCrud<User>{
    User findByEmail(User user) throws SQLException;
}
