package com.grigorovich.db_it.app.repositories;

import com.grigirovich.db_it.model.Student;

import java.util.List;

public interface StudentRepository extends Repository<Student> {
    List<Student> findMath();
    List<Student> findNoahSmith();
}
