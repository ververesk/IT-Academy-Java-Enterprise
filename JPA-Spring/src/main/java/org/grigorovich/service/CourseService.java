package org.grigorovich.service;

import org.grigorovich.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void saveCourse(Course course); //метод сохранения работника в базу данных

    Course getCourse(int id); //получаем работника по id

    void deleteCourse(int id);
}
