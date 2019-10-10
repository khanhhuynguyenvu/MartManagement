package group.jpa.ogm.app.repository;

import group.jpa.ogm.app.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    EntityManager entityManager;
    public Customer findCustomer(String id) {
        return entityManager.find(Customer.class,id);
    }

    public void save(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
    }

    public void remove(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(customer);
        transaction.commit();
    }

    public void update(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(customer);
        transaction.commit();
    }
}
