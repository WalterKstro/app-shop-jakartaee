package com.walterkstro.controllers;

import com.walterkstro.models.User;
import com.walterkstro.services.*;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/products")
public class Listar extends HttpServlet {
    @Inject
    @Named("conn")
    private Connection requestConnection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionService serviceSession = new SessionImplement();
        ServiceCrud productService = new ImplementServiceProduct( requestConnection );
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
