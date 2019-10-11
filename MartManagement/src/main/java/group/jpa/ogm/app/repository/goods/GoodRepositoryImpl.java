package group.jpa.ogm.app.repository.goods;

import group.jpa.ogm.app.entities.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class GoodRepositoryImpl implements GoodRepository {
    @Autowired
    EntityManager entityManager;
    public void save(Good good) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(good);
        transaction.commit();
    }

    public Good find(String id) {
        return entityManager.find(Good.class,id);
    }

    public void update(Good good) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(good);
        transaction.commit();
    }

    public void remove(Good good) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(good);
        transaction.commit();
    }
}
