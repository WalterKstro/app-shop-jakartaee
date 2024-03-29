package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.services.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;


@WebServlet("/cart/add")
public class Add extends HttpServlet {

    @Inject
    private Cart cart;
    @Inject
    private ServiceCrud<Product> productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException, NumberFormatException {

        try{
            Integer id = Integer.parseInt(req.getParameter("id"));
            Optional<Product> isProduct = productService.findById(id);

            if( isProduct.isPresent() ){
                Item item = new Item(1,isProduct.get() );
                cart.addItem( item );
            }
            resp.sendRedirect(req.getContextPath()+"/cart/me");
        }catch (Exception e) {
            resp.sendRedirect(req.getContextPath()+"/cart/me");
        }
    }
}
