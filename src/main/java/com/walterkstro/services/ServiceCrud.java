package com.walterkstro.services;

import java.util.List;
import java.util.Optional;

public interface ServiceCrud<E>{
    List<E> get();
    Optional<E> findById(Integer id);
    void save(E e);
    int delete(int id);
}
