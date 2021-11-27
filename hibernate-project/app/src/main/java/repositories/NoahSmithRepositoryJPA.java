package repositories;

import org.grigorovich.model.NoahSmith;

import javax.persistence.TypedQuery;

public class NoahSmithRepositoryJPA extends AbstractRepositoryJpa<NoahSmith> implements NoahSmithRepository{
    private static volatile NoahSmithRepositoryJPA instance;

    private NoahSmithRepositoryJPA() {
        //singleton
    }

    public static NoahSmithRepositoryJPA getInstance() {
        if (instance == null) {
            synchronized (NoahSmithRepositoryJPA.class) {
                if (instance == null) {
                    instance = new NoahSmithRepositoryJPA();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<NoahSmith> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from NoahSmith ", NoahSmith.class);
    }

}
