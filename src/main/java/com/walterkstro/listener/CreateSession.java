package com.walterkstro.listener;

import com.walterkstro.models.CartModel;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class CreateSession implements
        ServletContextListener,
        ServletRequestListener,
        HttpSessionListener {
    private ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("iniciando la app");
        context = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.log("destruyendo la app");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        context.log("destruyendo el request");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        context.log("iniciando el request");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        CartModel cart = new CartModel();
        HttpSession session = se.getSession();
        session.setAttribute("cart", cart);
        context.log("creando session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        context.log("destruyendo la session");
    }
}
