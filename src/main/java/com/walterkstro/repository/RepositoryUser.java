package com.walterkstro.repository;

import com.walterkstro.models.User;

import java.sql.SQLException;
import java.util.Optional;

public interface RepositoryUser extends Repository<User>{
    User findByEmail(User user) throws SQLException;
}
