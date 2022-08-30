package com.walterkstro.controllers;

import com.walterkstro.services.ServiceImplement;
import com.walterkstro.services.ServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet({"/login","/login.html"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceInterface service = new ServiceImplement();
        var cookie = service.getCookie(req);

        if( cookie.isEmpty() ){
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            resp.setContentType("text/html");
            try( PrintWriter out = resp.getWriter(); ){
                out.println ("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Welcome</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bienvenido de nuevo "+  service.restoreUsername(cookie.get()) + " </h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var username = req.getParameter("username");
        var password = req.getParameter("password");

        if( username.equalsIgnoreCase(username) && password.equalsIgnoreCase(password) ){
            Cookie cookie = new Cookie("username", URLEncoder.encode( username, "UTF-8" ));
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/products");
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
