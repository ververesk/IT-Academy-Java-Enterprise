package com.grigorovich.db_it.app.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository <T>{
    List<T> findAll();
//    Optional<T> find(int id);
//    T update(T entity);
//    T insert(T entity);
//    Optional<T> remove(T entity);
}
