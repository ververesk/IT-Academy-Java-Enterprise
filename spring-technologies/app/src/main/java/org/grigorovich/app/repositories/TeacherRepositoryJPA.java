package org.grigorovich.app.repositories;

import org.grigorovich.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepositoryJPA implements AbstractRepository<Teacher>{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Teacher> allTeachers = session.createQuery("from Teacher ", Teacher.class).getResultList(); //пишем не название таблицы а название класса entity для таблицы
        return allTeachers;
    }

    @Override
    public void saveEntity(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        if (teacher.getId()!=0) {
            Query query = session.createQuery("UPDATE Teacher t SET t.name=:tName, t.surname=:tSurname, t.salary=:tSalary, t.course=:tCourse, t.username=:tUsername  WHERE t.id=:tId");
            query.setParameter("tName", teacher.getName());
            query.setParameter("tSurname", teacher.getSurname());
            query.setParameter("tSalary", teacher.getSalary());
            query.setParameter("tCourse", teacher.getCourse());
            query.setParameter("tUsername", teacher.getUsername());
            query.setParameter("tId", teacher.getId());
            query.executeUpdate();
        } else {
            session.persist(teacher);
        }
    }

    @Override
    public Teacher getEntity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, id);
        return teacher;
    }

    @Override
    public void deleteEntity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Teacher> query = session.createQuery("delete from Teacher where id=:teacherId");
        query.setParameter("teacherId", id);
        query.executeUpdate();
    }
}
