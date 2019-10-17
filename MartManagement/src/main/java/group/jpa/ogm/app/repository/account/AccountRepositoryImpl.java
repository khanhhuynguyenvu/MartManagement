package group.jpa.ogm.app.repository.account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import group.jpa.ogm.app.entities.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	@Autowired
	EntityManager entityManager;

	public Account findAccount(String id) {
		return entityManager.find(Account.class, id);
	}

	public List<Account> findAcccountByUsername(String username) {
		String squery = "db.account.find({})";
		Query query = entityManager.createNativeQuery(squery, Account.class);
		@SuppressWarnings("unchecked")
		List<Account> acc = query.getResultList();
		System.out.println("############# : " + query.getResultList().toString());
		System.out.println("######## QUERY : " + query.getResultList().size());
		System.out.println("NAME: "+acc.get(0).getUsername());
		return acc;
	}

	public void save(Account account) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(account);
		transaction.commit();
	}

	public void remove(Account account) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(account);
		transaction.commit();
	}

	public void update(Account account) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(account);
		transaction.commit();
	}

}
