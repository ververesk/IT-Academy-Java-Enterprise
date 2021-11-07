package com.grigorovich.db_it.app.repositories;

import java.sql.Connection;
import java.util.List;

public interface Repository <T>{
    List<T> findAll();
   T find(int id);
    void update(T entity);
//    T insert(T entity);
//    Optional<T> remove(T entity);
}
