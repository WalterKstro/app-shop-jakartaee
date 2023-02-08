package com.walterkstro.producers;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Stateless
public class ProducerConnection {
    public ProducerConnection() {}

    @Produces
    @RequestScoped
    @Named("conn")
    private Connection makeConnection() throws NamingException, SQLException {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/myDataSource");
        return ds.getConnection();
    }
}
