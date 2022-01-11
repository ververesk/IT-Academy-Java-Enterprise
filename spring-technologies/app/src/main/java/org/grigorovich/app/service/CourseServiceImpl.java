package org.grigorovich.app.service;

import org.grigorovich.app.repositories.AbstractRepository;
import org.grigorovich.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CourseServiceImpl implements EntityService<Course>{
    @Qualifier("courseRepositoryJPA")
    @Autowired
    private AbstractRepository abstractRepository;

    @Override
    @Transactional
    public List<Course> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    @Transactional
    public void saveEntity(Course course) {
        abstractRepository.saveEntity(course);
    }

    @Override
    @Transactional
    public Course getEntity(int id) {
        return (Course) abstractRepository.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        abstractRepository.deleteEntity(id);
    }
}
