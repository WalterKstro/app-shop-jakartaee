package com.walterkstro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Params.URL.getParam(),
                Params.USERNAME.getParam(),
                Params.PASSWORD.getParam()
        );
    }
}
