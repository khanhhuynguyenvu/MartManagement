package group.jpa.ogm.app.repository.invoice;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Invoice;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

@Component
public class InvoiceDAOImpl extends GenericsDAOImpl<Invoice> implements InvoiceDAO {

	public InvoiceDAOImpl(EntityManager entityManager) throws RemoteException {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
