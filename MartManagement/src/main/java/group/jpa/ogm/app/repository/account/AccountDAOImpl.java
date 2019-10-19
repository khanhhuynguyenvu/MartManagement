package group.jpa.ogm.app.repository.account;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;

@Component
public class AccountDAOImpl extends GenericsDAOImpl<Account> implements AccountDAO {
    public AccountDAOImpl(EntityManager entityManager) throws RemoteException {
        super(entityManager);
    }
}
