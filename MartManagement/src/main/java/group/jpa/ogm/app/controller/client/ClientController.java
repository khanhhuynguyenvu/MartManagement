package group.jpa.ogm.app.controller.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import group.jpa.ogm.app.repository.account.AccountDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;

public class ClientController {
	private Registry registry;

	public ClientController(String hOST, int pORT) throws RemoteException {
		super();
		this.registry = LocateRegistry.getRegistry(hOST, pORT);
	}

	public AccountDAO getAccountDAO() throws AccessException, RemoteException, NotBoundException {
		return (AccountDAO) this.registry.lookup(AccountDAO.class.getSimpleName());
	}

	public EmployeeDAO getEmployeeDAO() throws AccessException, RemoteException, NotBoundException {
		return (EmployeeDAO) this.registry.lookup(EmployeeDAO.class.getSimpleName());
	}

}
