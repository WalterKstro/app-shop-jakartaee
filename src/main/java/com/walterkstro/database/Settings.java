package com.walterkstro.database;

public enum Settings {
    URL("jdbc:mysql://localhost:3306/shop"),
    USERNAME("tux"),
    PASSWORD("tux");
    private final String param;

    Settings(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
