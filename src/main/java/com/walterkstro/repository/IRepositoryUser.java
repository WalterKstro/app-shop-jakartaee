package com.walterkstro.repository;

import com.walterkstro.models.User;

import java.sql.SQLException;
import java.util.Optional;

public interface IRepositoryUser extends IRepositoryCrud<User>{
    User findByEmail(User user) throws SQLException;
}
