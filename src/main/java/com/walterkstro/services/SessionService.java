package com.walterkstro.services;

import com.walterkstro.models.Cart;
import com.walterkstro.models.User;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface SessionService {
    Optional<User> isSession(HttpServletRequest req);
    String restoreUsername(String username);
    Optional<Cart> getCart(HttpServletRequest req);
}
