package com.walterkstro.controllers;

import com.walterkstro.models.CartModel;
import com.walterkstro.models.ItemModel;
import com.walterkstro.services.SessionImplement;
import com.walterkstro.services.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/cart")
public class ViewCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionService session = new SessionImplement();
        Optional<CartModel> cart = session.getCart(req);

        if( cart.isPresent() ){
            List<ItemModel> list = cart.get().getList();
            float total = cart.get().getTotal();
            req.setAttribute("cart", list);
            req.setAttribute("isAuth", true);
            req.setAttribute("total", total);
        }else {
            req.setAttribute("isAuth", false);
        }

        getServletContext().getRequestDispatcher("/cart.jsp").forward(req,resp);
    }
}
