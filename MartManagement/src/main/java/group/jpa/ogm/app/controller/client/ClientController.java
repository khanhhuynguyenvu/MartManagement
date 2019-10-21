package group.jpa.ogm.app.controller.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import group.jpa.ogm.app.repository.account.AccountDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;

public class ClientController {
	private static final String HOST = "172.16.0.155";
	private static final int PORT = 9999;
	private static Registry registry;

	public ClientController() throws RemoteException {
		this.registry = LocateRegistry.getRegistry(HOST, PORT);
	}
	
	public AccountDAO getAccountDAO() throws AccessException, RemoteException, NotBoundException {
		return (AccountDAO) this.registry.lookup(AccountDAO.class.getSimpleName());
	}
	public EmployeeDAO getEmployeeDAO() throws AccessException, RemoteException, NotBoundException {
		return (EmployeeDAO) this.registry.lookup(EmployeeDAO.class.getSimpleName());
	}
	
}
