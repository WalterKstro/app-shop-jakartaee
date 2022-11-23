package com.walterkstro.controllers;

import com.walterkstro.services.SessionImplement;
import com.walterkstro.services.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionService service = new SessionImplement();
        boolean auth = service.isSession(req).isPresent();

        if( auth ){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }
}
