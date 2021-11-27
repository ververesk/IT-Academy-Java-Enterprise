import org.grigorovich.dto.StudentDTO;
import org.grigorovich.model.Student;
import repositories.RepositoryFactory;
import repositories.StudentRepository;

import java.util.List;

public class Runner {

    private static final StudentRepository repository = RepositoryFactory.getStudentRepository();
    public static void main(String[] args) {
        List<StudentDTO> students = repository.findAll();
        System.out.println(students);
    }
}
