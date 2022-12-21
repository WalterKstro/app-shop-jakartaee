package com.walterkstro.controllers;

import com.walterkstro.models.User;
import com.walterkstro.services.ImplementServiceUser;
import com.walterkstro.services.ServiceUser;
import com.walterkstro.services.SessionImplement;
import com.walterkstro.services.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionService service = new SessionImplement();
        var session = service.isSession(req);

        if( session.isEmpty() ){
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection requestConnection = (Connection) req.getAttribute("connection");
        ServiceUser authentication = new ImplementServiceUser(requestConnection);

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
