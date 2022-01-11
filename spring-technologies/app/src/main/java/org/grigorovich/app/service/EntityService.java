package org.grigorovich.app.service;


import java.util.List;

public interface EntityService <T>{
    List<T> getAll();
    void saveEntity(T entity); //метод сохранения работника в базу данных

    T getEntity(int id); //получаем работника по id

    void deleteEntity(int id);
}
