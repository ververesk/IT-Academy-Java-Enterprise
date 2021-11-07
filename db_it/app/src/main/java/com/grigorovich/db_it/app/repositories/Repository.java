package com.grigorovich.db_it.app.repositories;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T find(int id);
    void update(T entity);
    void insert(T entity);
    void remove(int id);
}
