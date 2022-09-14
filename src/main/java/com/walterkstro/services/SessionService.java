package com.walterkstro.services;

import com.walterkstro.models.CartModel;
import com.walterkstro.models.ProductModel;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    Optional<String> getSession(HttpServletRequest req);

    String restoreUsername(String username);
    Optional<CartModel> getCart(HttpServletRequest req);
}
