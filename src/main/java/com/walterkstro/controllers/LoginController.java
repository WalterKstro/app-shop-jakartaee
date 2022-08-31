package com.walterkstro.controllers;

import com.walterkstro.services.ServiceImplement;
import com.walterkstro.services.ServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/login","/login.html"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceInterface service = new ServiceImplement();
        var session = service.getSession(req);

        if( session.isEmpty() ){
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var username = req.getParameter("username");
        var password = req.getParameter("password");

        if( username.equalsIgnoreCase(username) && password.equalsIgnoreCase(password) ){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);

            resp.sendRedirect(req.getContextPath() + "/products");
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
