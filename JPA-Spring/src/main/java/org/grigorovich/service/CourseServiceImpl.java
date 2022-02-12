package org.grigorovich.service;

import org.grigorovich.model.Course;
import org.grigorovich.repositories.CourseRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepositoryJPA courseRepositoryJPA;

    @Override
    @Transactional
    public List<Course> getAllCourses() {
        return courseRepositoryJPA.findAll();
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        courseRepositoryJPA.saveAndFlush(course);
    }

    @Override
    @Transactional
    public Course getCourse(int id) {
        Course course = null;
        Optional<Course> optional = courseRepositoryJPA.findById(id);
        if (optional.isPresent()) {
            course = optional.get();
        }
        return course;
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        courseRepositoryJPA.deleteById(id);
    }


    @Transactional
    @Override
    public void saveAllCourses(List<Course> courseList) {
        courseRepositoryJPA.saveAll(courseList);
    }
}