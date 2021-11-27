package repositories;

import org.grigorovich.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class TeacherRepositoryJPA extends AbstractRepositoryJpa<Teacher>implements TeacherRepository{
    private static volatile TeacherRepositoryJPA instance;

    private TeacherRepositoryJPA() {
        //singleton
    }

    public static TeacherRepositoryJPA getInstance() {
        if (instance == null) {
            synchronized (TeacherRepositoryJPA.class) {
                if (instance == null) {
                    instance = new TeacherRepositoryJPA();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Teacher> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Teacher", Teacher.class);
    }

    @Override
    public void insert(Teacher teacher) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (teacher.getId() == 0) {
            em.persist(teacher);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void update(Teacher teacher) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (teacher.getId() != 0) {
            em.merge(teacher);
        }
        em.getTransaction().commit();
        em.close();
    }
}
