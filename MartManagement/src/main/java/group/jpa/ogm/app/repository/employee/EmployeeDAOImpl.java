package group.jpa.ogm.app.repository.employee;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

@Component
public class EmployeeDAOImpl extends GenericsDAOImpl<Employee> implements EmployeeDAO {

	public EmployeeDAOImpl() throws RemoteException {
		super();
	}
}
