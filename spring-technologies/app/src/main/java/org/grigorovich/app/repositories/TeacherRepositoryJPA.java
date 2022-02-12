package org.grigorovich.app.repositories;

import org.grigorovich.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Прописала свой метод update иначе hibernate творил дичь невероятную
 */
@Repository
public class TeacherRepositoryJPA implements AbstractRepository<Teacher>, InfoAboutTeachersRepository {
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
        if (teacher.getId() != 0) {
            Query query = session.createQuery("UPDATE Teacher t SET t.name=:tName, t.surname=:tSurname, t.salary=:tSalary, t.username=:tUsername  WHERE t.id=:tId");
            query.setParameter("tName", teacher.getName());
            query.setParameter("tSurname", teacher.getSurname());
            query.setParameter("tSalary", teacher.getSalary());
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
        return session.get(Teacher.class, id);
    }

    @Override
    public void deleteEntity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Teacher> query = session.createQuery("delete from Teacher where id=:teacherId");
        query.setParameter("teacherId", id);
        query.executeUpdate();
    }

    @Override
    public Long sumTeacherSalary() {
        Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery("Select sum(t.salary) FROM Teacher t", Long.class);
        return query.getSingleResult();
    }

    @Override
    public String avgTeacherSalary() {
        Session session = sessionFactory.getCurrentSession();
        javax.persistence.Query query = session.createQuery("Select avg(t.salary) FROM Teacher t", Double.class);
        Double avgSalaries = (Double) query.getSingleResult();
        return String.format("%.2f", avgSalaries);
    }
}
