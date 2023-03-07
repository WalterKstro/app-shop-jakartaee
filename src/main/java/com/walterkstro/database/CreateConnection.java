package com.walterkstro.database;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;

public class CreateConnection {

    @Resource(name="jdbc/myDataSource")
    private DataSource ds;

    @Produces
    @RequestScoped
    @ConnectionMySQL
    public Connection getConnection() throws SQLException, NamingException {
        return ds.getConnection();
    }
}
