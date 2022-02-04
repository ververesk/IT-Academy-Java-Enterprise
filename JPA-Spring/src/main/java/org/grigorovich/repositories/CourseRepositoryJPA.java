package org.grigorovich.repositories;

import org.grigorovich.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryJPA implements AbstractRepository<Course> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Course> allCourses = session.createQuery("from Course ", Course.class).getResultList(); //пишем не название таблицы а название класса entity для таблицы
        return allCourses;
    }

    @Override
    public void saveEntity(Course course) {
        Session session = sessionFactory.getCurrentSession();
        if (course.getCourseId()!=0) {
            session.merge(course);
        } else {
            session.persist(course);
        }
    }

    @Override
    public Course getEntity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class, id);
        return course;
    }

    @Override
    public void deleteEntity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Course> query = session.createQuery("delete from Course where id=:courseId");
        query.setParameter("courseId", id);
        query.executeUpdate();
    }
}
