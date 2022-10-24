package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/cart/add")
public class AddCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException, NumberFormatException {
        Connection requestConnection = (Connection) req.getAttribute("connection");

        try{
            Integer id = Integer.parseInt(req.getParameter("id"));
            ProductService productService = new ServiceProductModel( requestConnection );
            Optional<ProductModel> isProduct = productService.findById(id);

            if( isProduct.isPresent() ){
                HttpSession session = req.getSession();
                ItemModel item = new ItemModel(isProduct.get() );
                CartModel cart = (CartModel) session.getAttribute("cart");

                cart.addItem(item);
                session.setAttribute("cart", cart);
            }
            resp.sendRedirect(req.getContextPath()+"/cart/me");
        }catch (Exception e) {
            resp.sendRedirect(req.getContextPath()+"/cart/me");
        }
    }
}
