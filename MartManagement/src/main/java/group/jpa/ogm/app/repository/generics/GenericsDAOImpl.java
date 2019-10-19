package group.jpa.ogm.app.repository.generics;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GenericsDAOImpl<T> extends UnicastRemoteObject implements GenericsDAO<T> {
	protected GenericsDAOImpl(EntityManager entityManager) throws RemoteException {
		super();
		this.entityManager = entityManager;
	}
	private static final long serialVersionUID = -3127853915912269457L;
	
	private final EntityManager entityManager;

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
