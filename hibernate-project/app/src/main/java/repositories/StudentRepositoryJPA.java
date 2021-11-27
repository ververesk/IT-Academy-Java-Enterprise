package repositories;

import org.grigorovich.model.Student;

import javax.persistence.TypedQuery;

public class StudentRepositoryJPA extends AbstractRepositoryJpa<Student> implements StudentRepository {
    private static volatile StudentRepositoryJPA instance;

    private StudentRepositoryJPA() {
        //singleton
    }

    public static StudentRepositoryJPA getInstance() {
        if (instance == null) {
            synchronized (StudentRepositoryJPA.class) {
                if (instance == null) {
                    instance = new StudentRepositoryJPA();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Student> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("select s.id , s.name, s.surname, s.age, s.username from Student s", Student.class);
    }
}
