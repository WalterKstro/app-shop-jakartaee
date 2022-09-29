package com.walterkstro.services;

import com.walterkstro.models.CartModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class SessionImplement implements SessionService {
    @Override
    public Optional<String> isSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        return (username == null) ? Optional.empty() : Optional.of(username);
    }

    @Override
    public String restoreUsername(String username) {
        return username.replace("+"," ");
    }

    @Override
    public Optional<CartModel> getCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        CartModel cart = (CartModel) session.getAttribute("cart");
        return (cart == null || cart.getList().isEmpty()) ? Optional.empty() : Optional.of(cart);
    }


}
