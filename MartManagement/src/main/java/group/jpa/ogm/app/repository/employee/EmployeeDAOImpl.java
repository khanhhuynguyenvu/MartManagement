package group.jpa.ogm.app.repository.employee;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

public class EmployeeDAOImpl extends GenericsDAOImpl<Employee> implements EmployeeDAO {
	public EmployeeDAOImpl() throws RemoteException {
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

	public Employee add(Employee e) throws RemoteException {

		EntityTransaction tr = entityManager.getTransaction();
		try {
			tr.begin();

			entityManager.persist(e);

			tr.commit();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return e;
	}

}
