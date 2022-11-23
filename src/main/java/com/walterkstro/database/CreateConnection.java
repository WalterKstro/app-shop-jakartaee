package com.walterkstro.database;

import java.sql.*;

public class CreateConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Params.URL.getParam(),
                Params.USERNAME.getParam(),
                Params.PASSWORD.getParam()
        );
    }
}
