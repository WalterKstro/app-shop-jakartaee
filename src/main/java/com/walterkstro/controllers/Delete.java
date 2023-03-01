package com.walterkstro.controllers;

import com.walterkstro.models.Product;
import com.walterkstro.services.ImplementServiceProduct;
import com.walterkstro.services.ServiceCrud;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/product/delete")
public class Delete extends HttpServlet {
    @Inject
    private ServiceCrud<Product> productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idDelete;
        try{
            idDelete = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException nfe){
            idDelete = 0;
        }

        if( idDelete == 0 ){
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }else {
            int rows = productService.delete(idDelete);
            if(rows == 1) {
                resp.sendRedirect(req.getContextPath()+"/products");
            }else {
                resp.sendRedirect(req.getContextPath()+"/404.jsp");
            }
        }
    }
}
