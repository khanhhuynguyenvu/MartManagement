package group.jpa.ogm.app.repository.goods;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;

@Component
public class GoodDAOImpl extends GenericsDAOImpl<Good> implements GoodDAO {
    public GoodDAOImpl(EntityManager entityManager) throws RemoteException {
        super(entityManager);
    }
}
