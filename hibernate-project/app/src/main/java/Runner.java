
import org.grigorovich.model.Course;
import org.grigorovich.model.Student;
import repositories.RepositoryFactory;
import repositories.StudentRepository;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

public class Runner {

    private static final StudentRepository repository = RepositoryFactory.getStudentRepository();
    public static void main(String[] args) {
        List<Student> students = repository.findAll();
        System.out.println(students);
        Optional<Student> query=repository.find(1);
        System.out.println(query);


    }
}
