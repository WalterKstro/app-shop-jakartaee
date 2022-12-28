package com.walterkstro.database;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;

public class CreateConnection {
    public static Connection getConnection() throws SQLException, NamingException {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/myDataSource");
        return ds.getConnection();
    }
}
