package repositories;

import org.grigorovich.model.Teacher;

public interface TeacherRepository extends Repository<Teacher>{
    Long sumTeacherSalary();
    String avgTeacherSalary();
}
