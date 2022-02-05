package org.grigorovich.service;

import org.grigorovich.model.MathCourse;
import org.grigorovich.repositories.MathCourseRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MathCourseServiceImpl implements MathCourseService {
    @Autowired
    private MathCourseRepositoryJPA mathCourseRepositoryJPA;

    @Override
    @Transactional
    public List<MathCourse> showAllStudents() {
        return mathCourseRepositoryJPA.findAll();
    }

    @Override
    @Transactional
    public void saveMathCourse(MathCourse mathCourse) {
        mathCourseRepositoryJPA.save(mathCourse);
    }

    @Override
    @Transactional
    public MathCourse getMathCourse(int id) {
        MathCourse course = null;
        Optional<MathCourse> optional = mathCourseRepositoryJPA.findById(id);
        if (optional.isPresent()) {
            course = optional.get();
        }
        return course;
    }
}

