package repositories;


import org.grigorovich.model.MathCourse;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MathRepositoryJPA extends AbstractRepositoryJpa<MathCourse> implements MathRepository {
    private static volatile MathRepositoryJPA instance;

    private MathRepositoryJPA() {
        //singleton
    }

    public static MathRepositoryJPA getInstance() {
        if (instance == null) {
            synchronized (MathRepositoryJPA.class) {
                if (instance == null) {
                    instance = new MathRepositoryJPA();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<MathCourse> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from MathCourse", MathCourse.class);
    }


    @Override
    public void update(MathCourse math) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (math.getId() != 0) {
            em.merge(math);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void insert(MathCourse math) {
    }
}

