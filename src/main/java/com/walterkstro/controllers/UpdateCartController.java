package com.walterkstro.controllers;

import com.walterkstro.models.CartModel;
import com.walterkstro.models.ItemModel;
import com.walterkstro.services.SessionImplement;
import com.walterkstro.services.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/update")
public class UpdateCartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var names = req.getParameterNames();
        var session = new SessionImplement();
        var cartSession = session.getCart(req).get();
        var listItems = cartSession.getList();
        var listIdDelete = new ArrayList<>();


        names.asIterator().forEachRemaining( name -> {
            if( name.startsWith("delete_") ){
                var id = name.split("_")[1];
                listIdDelete.add( Integer.valueOf( id ) );
            }
        });


        if( listIdDelete.size() > 0 ){
            listItems = listItems.stream()
                    .filter( item -> !listIdDelete.contains( Integer.valueOf( item.getProduct().getId() ) ))
                    .collect(Collectors.toList());
        }

        cartSession.setList( listItems );
        var sessionUsername = req.getSession();
        sessionUsername.setAttribute("cart", cartSession);

        //getServletContext().getRequestDispatcher("/example.jsp").forward(req,resp);
    }
}
