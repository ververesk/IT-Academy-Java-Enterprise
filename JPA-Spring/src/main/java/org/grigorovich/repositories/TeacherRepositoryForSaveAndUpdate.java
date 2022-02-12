package org.grigorovich.repositories;

import org.grigorovich.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class TeacherRepositoryForSaveAndUpdate {

    @Autowired
    private EntityManager entityManager;

    public void saveOrUpdateTeacher(Teacher teacher) {
        if (teacher.getId() != 0) {
            Query query = entityManager.createQuery("UPDATE Teacher t SET t.name=:tName, t.surname=:tSurname, t.salary=:tSalary, t.username=:tUsername  WHERE t.id=:tId");
            query.setParameter("tName", teacher.getName());
            query.setParameter("tSurname", teacher.getSurname());
            query.setParameter("tSalary", teacher.getSalary());
            query.setParameter("tUsername", teacher.getUsername());
            query.setParameter("tId", teacher.getId());
            query.executeUpdate();
        } else {
            entityManager.persist(teacher);
        }
    }
}
