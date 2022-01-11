package org.grigorovich.app.service;


import org.grigorovich.app.repositories.AbstractRepository;
import org.grigorovich.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements EntityService<Student>{
    @Autowired
    private AbstractRepository abstractRepository;

    @Override
    @Transactional //Spring берет на себя ответственность за открытие и закытие транщакций
    public List<Student> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    @Transactional
    public void saveEntity(Student student) {
        abstractRepository.saveEntity(student);
    }

    @Override
    @Transactional
    public Student getEntity(int id) {
        return (Student) abstractRepository.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        abstractRepository.deleteEntity(id);
    }
}
