package org.grigorovich.app.service;


import java.util.List;

public interface EntityService <T>{
    List<T> getAll();
    void saveEntity(T entity);

    T getEntity(int id);

    void deleteEntity(int id);
}
