package com.walterkstro.filters;

import com.walterkstro.models.User;
import com.walterkstro.services.SessionImplement;
import com.walterkstro.services.SessionService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/cart/*","/product/*"})
public class ProtegeRouters implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");

        SessionService session = new SessionImplement();
        Optional<User> userSession = session.isSession((HttpServletRequest) servletRequest);

        if(userSession.isPresent()){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            //resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"You aren't authenticated");
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            req.getRequestDispatcher("/unauthorized.jsp").forward(req,resp);
        }
    }
}
