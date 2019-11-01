package group.jpa.ogm.app.repository.account;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class AccountDAOImpl extends GenericsDAOImpl<Account> implements AccountDAO {

	private MongoClient client = new MongoClient("localhost", 27017);
	private MongoDatabase db = client.getDatabase("MartDB");
	private MongoCollection<Document> cols = db.getCollection("Accounts");
	Gson gson = new Gson();

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

	@SuppressWarnings("unchecked")
	public Account findByEmployee(String id) {

		EntityTransaction tr = entityManager.getTransaction();
		List<Account> list = null;
		try {
			tr.begin();

			Document query1 = new Document(new Document("account_id", id));
			Gson gson = new Gson();
			Query query = entityManager.createNativeQuery(gson.toJson(query1), Account.class);
			list = (List<Account>) query.getResultList();
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list.get(0);
	}

	public boolean deleteById(String id) throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();

		try {
			tr.begin();

			Document query1 = new Document(new Document("_id", id));

			Gson gson = new Gson();

			Query query = entityManager.createNativeQuery(gson.toJson(query1), Account.class);

			// System.out.println(query.getSingleResult());

			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public Account findPassOld(String mkc) {
		EntityTransaction tr = entityManager.getTransaction();
		List<Account> list = null;
		try {
			tr.begin();
			Document query1 = new Document(new Document("Password", mkc));
			Gson gson = new Gson();

			Query query = entityManager.createNativeQuery(gson.toJson(query1), Account.class);

			list = (List<Account>) query.getResultList();
			tr.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list.get(0);
	}

	public boolean checkPassOld(String mkc, String mkm) {
		if (findPassOld(mkc).getPassword().equals(mkm))
			return true;
		return false;
	}

	public boolean changePass(Account ac, String mkm) {
		EntityTransaction tr = entityManager.getTransaction();
		int list = 0;
		try {
			tr.begin();
//			db.Accounts.updateOne({"_id":"8645822b-cfa7-42b1-92c5-92c3cddfba39"},
//			$set:{"Password":"2"},
//			$currentDate:{lastModified: true}})

			Document query1 = new Document();

			query1.append("$set", new Document().append("Password", mkm));

			Document filter = new Document().append("_id", ac.getId());

			cols.updateOne(filter, query1);

			System.out.println("ok");

			Query query = entityManager.createNativeQuery(gson.toJson(query1), Account.class);

			list = query.executeUpdate();
			tr.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list > 0;
	}

	@Override
	public List<Account> findAll() throws RemoteException {
		EntityTransaction tr = entityManager.getTransaction();
		List<Account> list = null;
		try {
			tr.begin();

			Document doc = new Document();
			Gson gson = new Gson();

			Query q = entityManager.createNativeQuery(gson.toJson(doc), Account.class);

			list = q.getResultList();
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}