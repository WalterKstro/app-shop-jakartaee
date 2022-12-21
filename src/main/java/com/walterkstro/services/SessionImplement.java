package com.walterkstro.services;

import com.walterkstro.models.Cart;
import com.walterkstro.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class SessionImplement implements SessionService {
    @Override
    public Optional<User> isSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User username = (User) session.getAttribute("user");
        return Optional.ofNullable( username );
    }

    @Override
    public String restoreUsername(String username) {
        return username.replace("+"," ");
    }

    @Override
    public Optional<Cart> getCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        return (cart == null || cart.getList().isEmpty()) ? Optional.empty() : Optional.of(cart);
    }


}
