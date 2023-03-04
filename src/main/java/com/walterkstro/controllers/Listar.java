package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.services.*;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/products")
public class Listar extends HttpServlet {
    @Inject
    private ServiceCrud<Product> productService;
    @Inject
    private SessionService serviceSession;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isAuth = serviceSession.isSession(req).isPresent();

        if(isAuth){
            User user = serviceSession.isSession(req).get();
            req.setAttribute("user",user);
        }

        req.setAttribute("products",productService.get());
        req.setAttribute("auth", isAuth);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
        dispatcher.forward(req,resp);
    }
}
