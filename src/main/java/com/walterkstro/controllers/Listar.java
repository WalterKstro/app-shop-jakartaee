package com.walterkstro.controllers;

import com.walterkstro.services.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/products")
public class Listar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection requestConnection = (Connection) req.getAttribute("connection");

        SessionService serviceSession = new SessionImplement();
        Service productService = new ProductService( requestConnection );
        boolean isAuth = serviceSession.isSession(req).isPresent();

        if(isAuth){
            String user = serviceSession.isSession(req).get();
            req.setAttribute("user", serviceSession.restoreUsername(user.toUpperCase()));
        }

        req.setAttribute("products",productService.get());
        req.setAttribute("auth", isAuth);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
        dispatcher.forward(req,resp);
    }
}
