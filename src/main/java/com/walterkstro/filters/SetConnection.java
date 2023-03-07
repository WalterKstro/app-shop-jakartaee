package com.walterkstro.filters;

import com.walterkstro.database.ConnectionMySQL;
import com.walterkstro.exceptions.ExceptionService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter({"/*"})
public class SetConnection implements Filter {
    public SetConnection() {}

    @Inject
    @ConnectionMySQL
    private Connection conn;
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        try( Connection connection = this.conn) {
            if( connection.getAutoCommit() ){
                connection.setAutoCommit(false);
            }

            try{
                filterChain.doFilter(servletRequest,servletResponse);
                connection.commit();
            } catch (SQLException | ExceptionService e) {
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
