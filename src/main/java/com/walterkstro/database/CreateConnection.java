package com.walterkstro.database;

import java.sql.*;

public class CreateConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Settings.URL.getParam(),
                Settings.USERNAME.getParam(),
                Settings.PASSWORD.getParam()
        );
    }
}
