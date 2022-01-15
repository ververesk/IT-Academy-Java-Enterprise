package org.grigorovich.app.repositories;

import org.grigorovich.model.MathCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Учитель может только смотреть информацию и редактировать оценки
 */
@Repository
public class MathCourseRepositoryJPA implements AbstractRepository<MathCourse> {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<MathCourse> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<MathCourse> mathCourses = session.createQuery("from MathCourse ", MathCourse.class).getResultList(); //пишем не название таблицы а название класса entity для таблицы
        return mathCourses;
    }

    @Override
    public void saveEntity(MathCourse mathCourse) {
        Session session = sessionFactory.getCurrentSession();
        if (mathCourse.getId()!=0) {
            session.merge(mathCourse);
        } else {
            session.persist(mathCourse);
        }
    }

    @Override
    public MathCourse getEntity(int id) {
        Session session = sessionFactory.getCurrentSession();
        MathCourse mathCourse = session.get(MathCourse.class, id);
        return mathCourse;
    }

    @Override
    public void deleteEntity(int id) {

    }
}
