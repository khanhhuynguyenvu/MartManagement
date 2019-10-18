package group.jpa.ogm.app.repository.generics;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericsDAOImpl<T> implements GenericsDAO<T> {
	@Autowired
	private EntityManager entityManager;

	public T findById(String id, Class<T> t) {
		return entityManager.find(t, id);
	}

	public void save(T t) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(t);
		transaction.commit();
	}

	public void remove(T t) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(t);
		transaction.commit();
	}

	public void update(T t) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(t);
		transaction.commit();
	}

}
