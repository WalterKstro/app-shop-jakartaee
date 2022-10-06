package com.walterkstro.controllers;

import com.walterkstro.models.CartModel;
import com.walterkstro.models.ItemModel;
import com.walterkstro.models.ProductModel;
import com.walterkstro.services.ProductImplement;
import com.walterkstro.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/cart/add")
public class AddCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException, NumberFormatException {

        try{
            int id = Integer.parseInt(req.getParameter("id"));
            ProductService productService = new ProductImplement();
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
