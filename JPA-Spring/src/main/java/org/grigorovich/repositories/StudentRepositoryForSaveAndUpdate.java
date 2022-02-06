package org.grigorovich.repositories;

import org.grigorovich.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class StudentRepositoryForSaveAndUpdate {

    @Autowired
    private EntityManager entityManager;

    public void saveOrUpdateStudent(Student student) {
        if (student.getId() != 0) {
            Query query = entityManager.createQuery("UPDATE Student s SET s.name=:sName, s.surname=:sSurname, s.age=:sAge, s.username=:sUsername  WHERE s.id=:sId");
            query.setParameter("sName", student.getName());
            query.setParameter("sSurname", student.getSurname());
            query.setParameter("sAge", student.getAge());
            query.setParameter("sUsername", student.getUsername());
            query.setParameter("sId", student.getId());
            query.executeUpdate();
        } else {
            entityManager.persist(student);
        }
    }
}
