package group.jpa.ogm.app.repository.invoiceDetails;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;

import group.jpa.ogm.app.entities.InvoiceDetails;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class InvoiceDetailsDAOImpl extends GenericsDAOImpl<InvoiceDetails> implements InvoiceDetailsDAO {

	public InvoiceDetailsDAOImpl(EntityManager entityManager) throws RemoteException {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	

}
