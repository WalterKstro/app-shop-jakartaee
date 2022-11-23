package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/cart/me"})
public class ViewCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionService session = new SessionImplement();
        Optional<Cart> cart = session.getCart(req);

        if( cart.isPresent() ){
            List<Item> list = cart.get().getList();
            String total = cart.get().formatCurrency();
            req.setAttribute("cart", list);
            req.setAttribute("isAuth", true);
            req.setAttribute("total", total);
        }else {
            req.setAttribute("isAuth", false);
        }

        getServletContext().getRequestDispatcher("/cart.jsp").forward(req,resp);
    }
}
