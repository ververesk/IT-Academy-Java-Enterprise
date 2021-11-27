package repositories;

import exception.DatabaseException;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractRepositoryJpa<T> implements Repository<T> {

    protected final EntityManagerHelper helper = EntityManagerHelper.getInstance();

    protected abstract TypedQuery<T> findAllQuery();

    @Override
    public List <T> findAll() {
        List<T> entities = new ArrayList<>();
        EntityManager em = null;
        try {
            em = helper.getEntityManager();
            em.getTransaction().begin();

            entities = findAllQuery().getResultList();

            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            safeRollback(em, e);
        } finally {
            quietCloseEntityManager(em);
        }
        return entities;
    }

    private void safeRollback(EntityManager em, Exception e) {
        log.error(e.getMessage(), e);
        if (em != null) {
            em.getTransaction().rollback();
        }
        throw new DatabaseException(e);
    }

    private void quietCloseEntityManager(EntityManager em) {
        if (em != null) {
            try {
                em.close();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public Optional<T> find(int id) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        T entity = em.find(getType(), id);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(entity);
    }

    private Class<T> getType() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return  (Class) type.getActualTypeArguments()[0];
    }

    @Override
    public void update(T entity) {
    }

    @Override
    public void insert(Object entity) {
    }

    @Override
    public void remove(int id) {
    }
}
