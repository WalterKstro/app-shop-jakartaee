package com.walterkstro.database;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;

public class CreateConnection {

    @Produces
    @RequestScoped
    @Named("conn")
    public static Connection getConnection() throws SQLException, NamingException {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/myDataSource");
        return ds.getConnection();
    }
}
