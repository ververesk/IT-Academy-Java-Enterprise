package org.grigorovich.app.service;

import org.grigorovich.app.repositories.AbstractRepository;
import org.grigorovich.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements EntityService<Teacher> {
    @Qualifier("teacherRepositoryJPA")
    @Autowired
    private AbstractRepository abstractRepository;

    @Override
    @Transactional
    public List<Teacher> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    @Transactional
    public void saveEntity(Teacher teacher) {
        abstractRepository.saveEntity(teacher);
    }

    @Override
    @Transactional
    public Teacher getEntity(int id) {
        return (Teacher) abstractRepository.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        abstractRepository.deleteEntity(id);
    }
}
