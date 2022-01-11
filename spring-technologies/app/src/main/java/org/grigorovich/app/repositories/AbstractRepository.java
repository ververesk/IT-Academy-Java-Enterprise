package org.grigorovich.app.repositories;


import java.util.List;

public interface AbstractRepository<T> {
    List<T> getAll();

    void saveEntity(T entity);

    T getEntity(int id);

    void deleteEntity(int id);
}
