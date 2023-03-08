package com.walterkstro.database;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.*;

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

    /*Close the connection*/
    public void closeConnection (@Disposes @ConnectionMySQL Connection connection ) throws SQLException {
        connection.close();
    }
}
