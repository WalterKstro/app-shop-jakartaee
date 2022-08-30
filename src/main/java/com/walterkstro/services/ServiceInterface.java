package com.walterkstro.services;

import com.walterkstro.models.ProductModel;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
    List<ProductModel> getList();
    Optional<String> getCookie(HttpServletRequest req);

    String restoreUsername(String username);
}
