package com.walterkstro.filters;

import com.walterkstro.exceptions.ExceptionService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebFilter({"/*"})
public class SetConnection implements Filter {
    public SetConnection() {}

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

            try{
                filterChain.doFilter(servletRequest,servletResponse);
            } catch (ExceptionService e) {
                var resp = (HttpServletResponse) servletResponse;
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
    }
}
