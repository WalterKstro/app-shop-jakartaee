package com.walterkstro.services;

import com.walterkstro.models.ProductModel;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ServiceImplement implements ServiceInterface{
    List<ProductModel> listado;

    public ServiceImplement() {
        this.listado = new ArrayList<>();
    }
    @Override
    public List<ProductModel> getList() {
        listado.add(new ProductModel("Smartv Samsung",1750.55f,"Entretenimiento"));
        listado.add(new ProductModel("IPhone 10X Pro",12750.55f,"Entretenimiento"));
        listado.add(new ProductModel("Estufa Mabe",1350.55f,"Electrodomestico"));
        listado.add(new ProductModel("Portatil HP Compaq",7550.55f,"Trabajo"));
        return listado;
    }

    @Override
    public Optional<String> getSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        return (username == null) ? Optional.empty() : Optional.of(username);
    }

    @Override
    public String restoreUsername(String username) {
        return username.replace("+"," ");
    }


}
