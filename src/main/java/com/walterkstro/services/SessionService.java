package com.walterkstro.services;

import com.walterkstro.models.CartModel;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface SessionService {
    Optional<String> isSession(HttpServletRequest req);

    String restoreUsername(String username);
    Optional<CartModel> getCart(HttpServletRequest req);
}
