package com.walterkstro.controllers;

import com.walterkstro.models.*;
import com.walterkstro.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

@WebServlet("/product/new")
public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getAttribute("connection");
        Service<Category> category = new CategoryService(connection);
        Service<Product> product = new ProductService(connection);

        List<Category> categories = category.get();
        Integer idUpdate;

        try{
            idUpdate = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException nfe){
            idUpdate = 0;
        }

        if( isCreate(idUpdate) ){
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }else {
            Optional<Product> item = product.findById(idUpdate);
             if( item.isPresent()){
                req.setAttribute("product", item.get());
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("/404.jsp").forward(req,resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection requestConnection = (Connection) req.getAttribute("connection");
        Service<Product> service = new ProductService( requestConnection );
        Map<String,String> errors = new HashMap<>();

        var description = req.getParameter("description");
        float price;
        int idCategory;
        int idProduct;

        try{
            price = Float.parseFloat( req.getParameter("price") );
        }catch (NumberFormatException nfe){
            price = 0f;
        }

        try{
            idProduct = Integer.parseInt( req.getParameter("id") );
        }catch (NumberFormatException nfe){
            idProduct = 0;
        }

        try{
            idCategory = Integer.parseInt(req.getParameter("category"));
        }catch (NumberFormatException nfe){
            idCategory = 0;
        }

        if( description.isEmpty() ){errors.put("description","Campo es requerido y/o invalido");}
        if( price == 0f ){errors.put("price","Campo es requerido y/o invalido");}
        if( idCategory == 0 ){errors.put("category","Campo es requerido");}



        if( errors.isEmpty() ){
            if (isCreate(idProduct)) {
                service.save( new Product(description, price, new Category(idCategory)));
            } else {
                service.save( new Product(idProduct, description, price, new Category(idCategory)));
            }
            resp.sendRedirect(req.getContextPath()+"/products");
        }else {
            req.setAttribute("errors", errors);
            doGet(req,resp);
        }
    }

    private boolean isCreate( Integer id ){
        return (id == null || id == 0) ? true : false;
    }
}
