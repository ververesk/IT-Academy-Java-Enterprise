package org.grigorovich.app.service;

import org.grigorovich.app.repositories.AbstractRepository;
import org.grigorovich.model.MathCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MathCourseServiceImpl implements EntityService<MathCourse> {
    @Qualifier("mathCourseRepositoryJPA")
    @Autowired
    private AbstractRepository abstractRepository;

    @Override
    @Transactional
    public List<MathCourse> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    @Transactional
    public void saveEntity(MathCourse mathCourse) {
        abstractRepository.saveEntity(mathCourse);
    }

    @Override
    @Transactional
    public MathCourse getEntity(int id) {
        return (MathCourse) abstractRepository.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        abstractRepository.deleteEntity(id);
    }
}
