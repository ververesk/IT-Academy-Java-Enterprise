package org.grigorovich.repositories;

import org.grigorovich.model.MathCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Учитель может только смотреть информацию и редактировать оценки
 */

public interface MathCourseRepositoryJPA extends JpaRepository<MathCourse, Integer> {
}
