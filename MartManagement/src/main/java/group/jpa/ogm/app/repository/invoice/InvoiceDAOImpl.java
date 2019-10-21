package group.jpa.ogm.app.repository.invoice;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;

import group.jpa.ogm.app.entities.Invoice;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class InvoiceDAOImpl extends GenericsDAOImpl<Invoice> implements InvoiceDAO {

	protected InvoiceDAOImpl(EntityManager entityManager) throws RemoteException {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
