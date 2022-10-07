package com.walterkstro.database;

public enum Params {
    URL("jdbc:mysql://localhost:3306/java-shop"),
    USERNAME("tux"),
    PASSWORD("tux");
    private final String param;

    Params(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
