package com.walterkstro.services;

import com.walterkstro.models.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.*;

import java.util.Optional;

@ApplicationScoped
public class ImplementSessionImplement implements SessionService {
    @Override
    public Optional<User> isSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User username = (User) session.getAttribute("user");
        return Optional.ofNullable( username );
    }

}
