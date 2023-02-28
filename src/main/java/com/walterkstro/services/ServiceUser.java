package com.walterkstro.services;

import com.walterkstro.models.User;

import java.util.Optional;

public interface ServiceUser extends ServiceCrud<User> {
    Optional<User> authentication(User user);
}
