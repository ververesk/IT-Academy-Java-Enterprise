
import org.grigorovich.model.Course;
import org.grigorovich.model.Student;
import repositories.RepositoryFactory;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

public class Runner {

    private static final StudentRepository repository = RepositoryFactory.getStudentRepository();
    private static final TeacherRepository teacherRepository = RepositoryFactory.getTeacherRepository();
    public static void main(String[] args) {
        List<Student> students = repository.findAll();
        System.out.println(students);
        Student query=repository.find(1);
        System.out.println(query);

        Long sum = teacherRepository.sumTeacherSalary();
        System.out.println(sum);

        String avg = teacherRepository.avgTeacherSalary();
        System.out.println(avg);


    }
}
