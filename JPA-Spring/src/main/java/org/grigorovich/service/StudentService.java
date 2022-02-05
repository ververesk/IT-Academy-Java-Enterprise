package org.grigorovich.service;

import org.grigorovich.model.Course;
import org.grigorovich.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
