package group.jpa.ogm.app.repository.repository.account;

import java.rmi.RemoteException;
import java.util.List;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.generics.GenericsDAO;

public interface AccountDAO extends GenericsDAO<Account> {
	Account findByUserName(String userName) throws RemoteException;
	List<Account> findAll() throws RemoteException;
}
