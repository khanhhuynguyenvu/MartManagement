package group.jpa.ogm.app.repository.employee;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

@Component
public class EmployeeDAOImpl extends GenericsDAOImpl<Employee> implements EmployeeDAO {
	public EmployeeDAOImpl(EntityManager entityManager) throws RemoteException {
		super(entityManager);
	}

	public Employee findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();
		String query = "db.Employee.find({'FullName':'{p1}'})";
		query = query.replace("{p1}", name);
		Query q = entityManager.createNativeQuery(query, Employee.class);
		System.out.println("Size : " + q.getResultList().size());
		@SuppressWarnings("unchecked")
		List<Employee> listEm = q.getResultList();
		tr.commit();
		return listEm.get(0);
	}

}
