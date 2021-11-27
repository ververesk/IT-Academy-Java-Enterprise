package repositories;

import org.grigorovich.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
                .createQuery("from Student", Student.class);
    }

    @Override
    public void insert(Student student) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (student.getId() == 0) {
            em.persist(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void update(Student student) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (student.getId() != 0) {
            em.merge(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}
