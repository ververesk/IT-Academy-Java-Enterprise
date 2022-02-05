package org.grigorovich.repositories;

import org.grigorovich.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepositoryJPA extends JpaRepository<Student, Integer> {
}
