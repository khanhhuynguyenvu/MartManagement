package group.jpa.ogm.app.repository.customer;

import java.rmi.RemoteException;

import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class CustomerDAOImpl extends GenericsDAOImpl<Customer> implements CustomerDAO {

	public CustomerDAOImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
