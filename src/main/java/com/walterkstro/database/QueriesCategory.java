package com.walterkstro.database;

public enum QueriesCategory {
    SELECT_ALL("SELECT cat_id,cat_name FROM categories ORDER BY cat_name ASC;"),
    SELECT_WHERE("SELECT cat_id,cat_name FROM categories WHERE cat_id = ?;"),
    INSERT_SIMPLE("INSERT INTO products(prod_description,prod_price,categories_cat_id) VALUES (?,?,?);"),
    UPDATE_SIMPLE("UPDATE products SET prod_description = ?,prod_price = ?, categories_cat_id = ? WHERE prod_id = ?;"),
    DELETE_SIMPLE("DELETE FROM products WHERE prod_id = ?;");
    private final String query;
    QueriesCategory(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
