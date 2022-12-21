package com.walterkstro.database;

public enum QueriesUser {
    SELECT_WHERE("SELECT user,email FROM users WHERE email = ? AND pw = ?;");

    private final String query;
    QueriesUser(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
