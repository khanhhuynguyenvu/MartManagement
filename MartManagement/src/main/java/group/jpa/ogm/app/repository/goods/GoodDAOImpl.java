package group.jpa.ogm.app.repository.goods;

import java.rmi.RemoteException;

import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class GoodDAOImpl extends GenericsDAOImpl<Good> implements GoodDAO {

	public GoodDAOImpl() throws RemoteException {
		super();
	}

}
