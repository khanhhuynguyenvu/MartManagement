package group.jpa.ogm.app.repository.account;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.bson.Document;

import com.google.gson.Gson;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class AccountDAOImpl extends GenericsDAOImpl<Account> implements AccountDAO {
	public AccountDAOImpl() throws RemoteException {
	}

	@SuppressWarnings("unchecked")
	public Account findByUserName(String userName) throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		List<Account> list = null;
		try {
			tr.begin();

			Document query1 = new Document(new Document("Username", userName));

			Gson gson = new Gson();

			Query query = entityManager.createNativeQuery(gson.toJson(query1), Account.class);

			list = (List<Account>) query.getResultList();

			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list.get(0);
	}

	public List<Account> findAll() throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		List<Account> list = null;
		try {
			tr.begin();

			String query1 = "db.Accounts.find({})";

			Gson gson = new Gson();

			Query query = entityManager.createNativeQuery(query1, Account.class);

			list = (List<Account>) query.getResultList();

			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public boolean deleteById(String id) throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		try {
			tr.begin();

			Document query1 = new Document(new Document("_id", id));

			Gson gson = new Gson();

			Query query = entityManager.createNativeQuery(gson.toJson(query1), Account.class);
			
			//System.out.println(query.getSingleResult());
			System.out.println(query.getResultList());
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
}
