package com.walterkstro.controllers;

import com.walterkstro.services.SessionImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/cart/update")
public class UpdateCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/cart/me").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var names = req.getParameterNames();
        var session = new SessionImplement();
        var cartSession = session.getCart(req).get();
        var listItems = cartSession.getList();

        var listOfMaps = createListForDeleteAndUpdateItems(req,names);
        var itemsForDelete = listOfMaps.get(0);
        var itemsForUpdate = listOfMaps.get(1);


        if( itemsForDelete.size() > 0 ){
            listItems = listItems.stream()
                    .filter( item -> !itemsForDelete.containsValue( Integer.valueOf( item.getProduct().getId() ) ))
                    .collect(Collectors.toList());
        }

        if( itemsForUpdate.size() > 0 ){
            listItems = listItems.stream()
                    .map( item ->  {
                        var id = String.valueOf(item.getProduct().getId());
                        var isUpdate = itemsForUpdate.containsKey( id );
                        item.setQuantity( itemsForUpdate.get(id).intValue() );
                        return item;
                    })
                    .collect(Collectors.toList());
        }

        cartSession.setList( listItems );
        var sessionUsername = req.getSession();
        sessionUsername.setAttribute("cart", cartSession);

        resp.sendRedirect(req.getContextPath()+"/cart/me");

    }

    private List<Map<String,Integer>> createListForDeleteAndUpdateItems(HttpServletRequest req, Enumeration<String> namesParams) {
        List<Map<String,Integer>> list = new ArrayList<>();
        Map<String,Integer> deletes = new HashMap<>();
        Map<String,Integer> updates = new HashMap<>();

        namesParams.asIterator().forEachRemaining( nameParam -> {
            if( nameParam.startsWith("delete_") ){
                var id = Integer.valueOf(req.getParameter(nameParam));
                deletes.put(nameParam,id);
            }
            if(nameParam.startsWith("quantity_")){
                var quantity = Integer.valueOf(req.getParameter(nameParam));
                var id = nameParam.split("_")[1];
                updates.put(id,quantity);
            }
        });

        list.add(deletes);
        list.add(updates);

        return list;
    }
}
