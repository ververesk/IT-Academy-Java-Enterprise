package org.grigorovich.service;

import org.grigorovich.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    void saveTeacher(Teacher teacher);

    Teacher getTeacher(int id);

    void deleteTeacher(int id);
    Long sumTeacherSalary();

    Double avgTeacherSalary();

    void saveOrUpdateTeacher(Teacher teacher);
}
