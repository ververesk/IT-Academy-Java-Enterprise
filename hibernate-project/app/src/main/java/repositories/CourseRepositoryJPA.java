package repositories;

import org.grigorovich.model.Course;
import org.grigorovich.model.Student;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CourseRepositoryJPA extends AbstractRepositoryJpa<Course> implements CourseRepository {
    private static volatile CourseRepositoryJPA instance;

    private CourseRepositoryJPA() {
        //singleton
    }

    public static CourseRepositoryJPA getInstance() {
        if (instance == null) {
            synchronized (CourseRepositoryJPA.class) {
                if (instance == null) {
                    instance = new CourseRepositoryJPA();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Course> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Course", Course.class);
    }

    @Override
    public void insert(Course course) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (course.getCourseId() == 0) {
            em.persist(course);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void update(Course course) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (course.getCourseId() != 0) {
            em.merge(course);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(int id) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        Query<Course> query = (Query<Course>) em.createQuery("delete from Course where courseId=:cId");
        query.setParameter("cId", id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
