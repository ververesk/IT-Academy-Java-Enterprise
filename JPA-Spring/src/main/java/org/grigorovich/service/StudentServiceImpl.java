package org.grigorovich.service;


import org.grigorovich.model.Student;
import org.grigorovich.repositories.StudentRepositoryForSaveAndUpdate;
import org.grigorovich.repositories.StudentRepositoryJPA;
import org.grigorovich.repositories.TeacherRepositoryForSaveAndUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositoryJPA studentRepositoryJPA;

    @Autowired
    private StudentRepositoryForSaveAndUpdate studentRepositoryForSaveAndUpdate;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepositoryJPA.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepositoryJPA.saveAndFlush(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        Student student = null;
        Optional<Student> optional = studentRepositoryJPA.findById(id);
        if (optional.isPresent()) {
            student = optional.get();
        }
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentRepositoryJPA.deleteById(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateStudent(Student student) {
        studentRepositoryForSaveAndUpdate.saveOrUpdateStudent(student);
    }
}
