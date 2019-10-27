package group.jpa.ogm.app.controller.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import group.jpa.ogm.app.entities.InvoiceDetails;
import group.jpa.ogm.app.repository.account.AccountDAO;
import group.jpa.ogm.app.repository.customer.CustomerDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;
import group.jpa.ogm.app.repository.goods.GoodDAO;
import group.jpa.ogm.app.repository.invoice.InvoiceDAO;
import group.jpa.ogm.app.repository.invoiceDetails.InvoiceDetailsDAO;

public class ClientController {
	private String HOST;
	private int PORT;
	private Registry registry;

	public ClientController(String hOST, int pORT) throws RemoteException {
		super();
		HOST = hOST;
		PORT = pORT;
		this.registry = LocateRegistry.getRegistry(hOST, pORT);
	}

	public AccountDAO getAccountDAO() throws AccessException, RemoteException, NotBoundException {
		return (AccountDAO) this.registry.lookup(AccountDAO.class.getSimpleName());
	}

	public EmployeeDAO getEmployeeDAO() throws AccessException, RemoteException, NotBoundException {
		return (EmployeeDAO) this.registry.lookup(EmployeeDAO.class.getSimpleName());
	}
	
	public GoodDAO getGoodDAO() throws AccessException, RemoteException, NotBoundException  {
		return (GoodDAO) this.registry.lookup(GoodDAO.class.getSimpleName());
	}
	
	public InvoiceDAO getInvoiceDAO() throws AccessException, RemoteException, NotBoundException {
		return (InvoiceDAO) this.registry.lookup(InvoiceDAO.class.getSimpleName());
	}

	public InvoiceDetailsDAO getInvoiceDetailsDAO() throws AccessException, RemoteException, NotBoundException {
		return (InvoiceDetailsDAO) this.registry.lookup(InvoiceDetailsDAO.class.getSimpleName());
	}

}
