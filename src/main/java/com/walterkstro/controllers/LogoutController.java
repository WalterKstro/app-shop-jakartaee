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

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceInterface service = new ServiceImplement();
        boolean auth = service.getCookie(req).isPresent();

        if( auth ){
            Cookie cookie = new Cookie("username", "");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}
