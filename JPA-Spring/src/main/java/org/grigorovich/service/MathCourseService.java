package org.grigorovich.service;

import org.grigorovich.model.Course;
import org.grigorovich.model.MathCourse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MathCourseService {

    List<MathCourse> showAllStudents();

    void saveMathCourse(MathCourse mathCourse);

    MathCourse getMathCourse(int id);

}
