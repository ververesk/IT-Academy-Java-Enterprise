package org.grigorovich.app.repositories;

import org.grigorovich.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentRepositoryJPA implements AbstractRepository<Student> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAll() {
        Session session=sessionFactory.getCurrentSession();
        List<Student> allStudents=session.createQuery("from Student ", Student.class).getResultList(); //пишем не название таблицы а название класса entity для таблицы
        return allStudents;
    }

    @Override
    public void saveEntity(Student student) {
        Session session=sessionFactory.getCurrentSession();
        if (student.getId()!=0) {
            Query query = session.createQuery("UPDATE Student s SET s.name=:sName, s.surname=:sSurname, s.age=:sAge, s.username=:sUsername  WHERE s.id=:sId");
            query.setParameter("sName", student.getName());
            query.setParameter("sSurname", student.getSurname());
            query.setParameter("sAge", student.getAge());
            query.setParameter("sUsername", student.getUsername());
            query.setParameter("sId", student.getId());
            query.executeUpdate();
        } else {
            session.persist(student);
        }
    }

    @Override
    public Student getEntity(int id) {
        Session session=sessionFactory.getCurrentSession();
        Student student=session.get(Student.class, id);
        return student;
    }

    @Override
    public void deleteEntity(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Student> query=session.createQuery("delete from Student where id=:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}
