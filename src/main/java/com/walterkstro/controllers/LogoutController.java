package com.walterkstro.controllers;

import com.walterkstro.services.ServiceImplement;
import com.walterkstro.services.ServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceInterface service = new ServiceImplement();
        boolean auth = service.getSession(req).isPresent();

        if( auth ){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}
