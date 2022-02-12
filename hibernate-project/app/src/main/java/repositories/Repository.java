package repositories;


import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();
    T find(int id);
    void update(T entity);
    void insert(T entity);
    void remove(int id);
}
