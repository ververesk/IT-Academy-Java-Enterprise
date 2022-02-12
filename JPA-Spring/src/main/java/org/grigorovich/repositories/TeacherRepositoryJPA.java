package org.grigorovich.repositories;

import org.grigorovich.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TeacherRepositoryJPA extends JpaRepository<Teacher, Integer> {
    @Query("Select sum(t.salary) FROM Teacher t")
    Long sumTeacherSalary();

    @Query("Select avg(t.salary) FROM Teacher t")
    Double avgTeacherSalary();
}