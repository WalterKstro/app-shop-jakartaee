package com.walterkstro.controllers;

import com.walterkstro.services.ProductImplement;
import com.walterkstro.services.ProductService;
import com.walterkstro.services.SessionImplement;
import com.walterkstro.services.SessionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionService service = new SessionImplement();
        ProductService product = new ProductImplement();
        boolean auth = service.isSession(req).isPresent();

        if(auth){
            String user = service.isSession(req).get();
            req.setAttribute("user", service.restoreUsername(user.toUpperCase()));
        }
        req.setAttribute("products",product.getList());
        req.setAttribute("auth", auth);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/table.jsp");
        dispatcher.forward(req,resp);
    }
}
