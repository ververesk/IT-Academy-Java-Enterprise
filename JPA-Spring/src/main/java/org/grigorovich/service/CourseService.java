package org.grigorovich.service;

import org.grigorovich.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void saveCourse(Course course);

    Course getCourse(int id);

    void deleteCourse(int id);

    void saveAllCourses(List<Course> courseList);
}
