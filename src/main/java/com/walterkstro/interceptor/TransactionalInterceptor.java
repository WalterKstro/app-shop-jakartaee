package com.walterkstro.interceptor;

import com.walterkstro.database.ConnectionMySQL;
import com.walterkstro.exceptions.ExceptionService;
import jakarta.inject.Inject;
import jakarta.interceptor.*;

import java.sql.Connection;

@AnotationTransactionInterceptor
@Interceptor
public class TransactionalInterceptor {
    @Inject
    @ConnectionMySQL
    private Connection connection;

    @AroundInvoke
    public Object interceptTransaction(InvocationContext invocation) throws Exception {
        if( connection.getAutoCommit() ){
            connection.setAutoCommit(false);
        }
        try{
            Object result = invocation.proceed();
            connection.commit();
            return result;
        }catch (ExceptionService ex){
            connection.rollback();
            throw ex;
        }
    }
}
