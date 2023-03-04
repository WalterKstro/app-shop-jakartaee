package com.walterkstro.controllers;

import com.walterkstro.models.User;
import com.walterkstro.services.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class Login extends HttpServlet {
    @Inject
    private ServiceUser authentication;
    @Inject
    private SessionService serviceSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = serviceSession.isSession(req);

        if( session.isEmpty() ){
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var email = req.getParameter("email");
        var password = req.getParameter("password");
        User userLogin = new User(email,password);

        Optional<User> auth = authentication.authentication(userLogin);

        if( auth.isPresent() ){
            HttpSession session = req.getSession();
            session.setAttribute("user",auth.get());

            resp.sendRedirect(req.getContextPath() + "/products");
        }else{
            resp.sendRedirect(req.getContextPath() + "/errorAuth.jsp");
        }
    }
}
