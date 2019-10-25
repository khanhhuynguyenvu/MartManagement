package group.jpa.ogm.app.repository.account;

import java.rmi.RemoteException;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class AccountDAOImpl extends GenericsDAOImpl<Account> implements AccountDAO {

	public AccountDAOImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
