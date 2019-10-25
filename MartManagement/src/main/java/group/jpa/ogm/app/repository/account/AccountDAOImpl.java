package group.jpa.ogm.app.repository.account;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

@Component
public class AccountDAOImpl extends GenericsDAOImpl<Account> implements AccountDAO {
	public AccountDAOImpl(EntityManager entityManager) throws RemoteException {
		super(entityManager);
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
}
