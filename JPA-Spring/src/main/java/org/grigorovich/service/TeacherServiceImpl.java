package org.grigorovich.service;

import org.grigorovich.model.Teacher;
import org.grigorovich.repositories.TeacherRepositoryForSaveAndUpdate;
import org.grigorovich.repositories.TeacherRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepositoryJPA teacherRepositoryJPA;

    @Autowired
    private TeacherRepositoryForSaveAndUpdate teacherRepositoryForSaveAndUpdate;

    @Override
    @Transactional
    public List<Teacher> getAllTeachers() {
        return teacherRepositoryJPA.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepositoryJPA.save(teacher);
    }


    @Override
    @Transactional
    public Teacher getTeacher(int id) {
        Teacher teacher = null;
        Optional<Teacher> optional = teacherRepositoryJPA.findById(id);
        if (optional.isPresent()) {
            teacher = optional.get();
        }
        return teacher;
    }

    @Override
    @Transactional
    public void deleteTeacher(int id) {
        teacherRepositoryJPA.deleteById(id);
    }

    @Override
    @Transactional
    public Long sumTeacherSalary() {
        return teacherRepositoryJPA.sumTeacherSalary();
    }

    @Override
    @Transactional
    public Double avgTeacherSalary() {
        return teacherRepositoryJPA.avgTeacherSalary();
    }

    @Override
    @Transactional
    public void saveOrUpdateTeacher(Teacher teacher) {
        teacherRepositoryForSaveAndUpdate.saveOrUpdateTeacher(teacher);
    }
}
