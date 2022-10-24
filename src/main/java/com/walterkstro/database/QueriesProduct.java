package com.walterkstro.database;

public enum QueriesProduct {
    SELECT_ALL("SELECT p.prod_id,p.prod_description,p.prod_price, c.cat_name FROM products AS p INNER JOIN categories AS c ON p.categories_cat_id = c.cat_id;"),
    SELECT_WHERE("SELECT P.prod_id,P.prod_description,P.prod_price,C.cat_name FROM products AS P INNER JOIN categories as C ON P.categories_cat_id = C.cat_id WHERE P.prod_id = ?;");
    private final String query;
    QueriesProduct(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
