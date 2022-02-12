package org.grigorovich.repositories;

import org.grigorovich.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepositoryJPA extends JpaRepository<Course, Integer> {
}