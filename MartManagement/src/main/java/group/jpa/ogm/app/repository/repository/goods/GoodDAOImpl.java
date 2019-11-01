package group.jpa.ogm.app.repository.repository.goods;

import org.bson.Document;

import com.google.gson.Gson;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.rmi.RemoteException;
import java.util.List;

public class GoodDAOImpl extends GenericsDAOImpl<Good> implements GoodDAO {
	public GoodDAOImpl() throws RemoteException {
	}

	public List<Good> findAll() throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();

		String query = "db.Good.find({})";
		Query q = entityManager.createNativeQuery(query, Good.class);

		List<Good> list = q.getResultList();
		tr.commit();

		return list;
	}

	public Good findByProductName(String name) throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();

		Document query = new Document(new Document("Name", name));

		Gson gson = new Gson();

		Query q = entityManager.createNativeQuery(gson.toJson(query), Good.class);

		List<Good> list = q.getResultList();

		tr.commit();

		return list.get(0);
	}

	public List<Good> findByProductKey(String key) throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();

		Document query = new Document("Name", new Document("$regex", key).append("$options", "i"));

		Gson gson = new Gson();
		Query q = entityManager.createNativeQuery(gson.toJson(query), Good.class);

		@SuppressWarnings("unchecked")
		List<Good> list = q.getResultList();

		tr.commit();

		return list;
	}
}
