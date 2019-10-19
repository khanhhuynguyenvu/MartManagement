package group.jpa.ogm.app.repository.customer;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;

@Component
public class CustomerDAOImpl extends GenericsDAOImpl<Customer> implements CustomerDAO {
    public CustomerDAOImpl(EntityManager entityManager) throws RemoteException {
        super(entityManager);
    }
}
