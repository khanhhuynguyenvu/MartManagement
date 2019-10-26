package group.jpa.ogm.app.repository.goods;

import java.rmi.RemoteException;
import java.util.List;

import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.repository.generics.GenericsDAO;

public interface GoodDAO extends GenericsDAO<Good> {
	List<Good> fillAll() throws RemoteException;
	Good findByProductName(String name) throws RemoteException;
	List<Good> findGoodByKey(String key) throws RemoteException;
}
