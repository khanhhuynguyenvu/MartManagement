package group.jpa.ogm.app.repository.goods;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.bson.Document;

import com.google.gson.Gson;

import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class GoodDAOImpl extends GenericsDAOImpl<Good> implements GoodDAO {
	public GoodDAOImpl() throws RemoteException {
	}

	
	public List<Good> fillAll() throws RemoteException {
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
}
