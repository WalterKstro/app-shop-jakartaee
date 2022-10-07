package com.walterkstro.filters;

import com.walterkstro.database.CreateConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebFilter({"/*"})
public class SetConnection implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        try( var connection = CreateConnection.getConnection()) {
            if( connection.getAutoCommit() ){
                connection.setAutoCommit(false);
            }

            try{
                servletRequest.setAttribute("connection",connection);
                filterChain.doFilter(servletRequest,servletResponse);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                var resp = (HttpServletResponse) servletResponse;
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }


        } catch (SQLException e) {
            var resp = (HttpServletResponse) servletResponse;
            resp.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }
}
