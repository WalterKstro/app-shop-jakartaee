package com.walterkstro.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Repository<E> {
    List<E> all() throws SQLException;
    E find(Integer id) throws SQLException;
    void save(E e) throws SQLException;
    void delete(E e) throws SQLException;
    E createInstance(ResultSet result) throws SQLException;
}
