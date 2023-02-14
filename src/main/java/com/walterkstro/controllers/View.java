package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/cart/me"})
public class View extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/cart.jsp").forward(req,resp);
    }
}
