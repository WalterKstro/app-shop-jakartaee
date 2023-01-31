package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.models.Product;
import com.walterkstro.services.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;


@WebServlet("/cart/add")
public class AddCart extends HttpServlet {
    @Inject
    private Cart cart;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException, NumberFormatException {
        Connection requestConnection = (Connection) req.getAttribute("connection");

        try{
            Integer id = Integer.parseInt(req.getParameter("id"));
            Service productService = new ImplementServiceProduct( requestConnection );
            Optional<Product> isProduct = productService.findById(id);

            if( isProduct.isPresent() ){
                Item item = new Item(isProduct.get() );
                cart.addItem(item);
            }
            resp.sendRedirect(req.getContextPath()+"/cart/me");
        }catch (Exception e) {
            resp.sendRedirect(req.getContextPath()+"/cart/me");
        }
    }
}
