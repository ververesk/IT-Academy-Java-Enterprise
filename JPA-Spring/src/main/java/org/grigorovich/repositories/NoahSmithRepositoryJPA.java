package org.grigorovich.repositories;

import org.grigorovich.model.NoahSmith;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Тут нам нужно только чтобы студент мог видеть список всех своих оценок и всё
 */
@Repository
public class NoahSmithRepositoryJPA implements AbstractRepository<NoahSmith> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<NoahSmith> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<NoahSmith> noahSmithInfo = session.createQuery("from NoahSmith ", NoahSmith.class).getResultList(); //пишем не название таблицы а название класса entity для таблицы
        return noahSmithInfo;
    }

    @Override
    public void saveEntity(NoahSmith entity) {

    }

    @Override
    public NoahSmith getEntity(int id) {
        return null;
    }

    @Override
    public void deleteEntity(int id) {

    }
}
