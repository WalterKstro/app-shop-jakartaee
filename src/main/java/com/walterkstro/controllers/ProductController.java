package com.walterkstro.controllers;

import com.walterkstro.services.ServiceImplement;
import com.walterkstro.services.ServiceInterface;
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
        ServiceInterface service = new ServiceImplement();
        boolean auth = service.getCookie(req).isPresent();

        if(auth){
            String user = service.getCookie(req).get();
            req.setAttribute("user", service.restoreUsername(user.toUpperCase()));
        }
        req.setAttribute("products",service.getList());
        req.setAttribute("auth", auth);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/table.jsp");
        dispatcher.forward(req,resp);
    }
}
