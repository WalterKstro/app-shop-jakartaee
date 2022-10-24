package com.walterkstro.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<E> {
    List<E> all() throws SQLException;
    E find(Integer id) throws SQLException;
    void save(E e) throws SQLException;
    void update(E e) throws SQLException;
}
