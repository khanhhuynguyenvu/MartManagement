package group.jpa.ogm.app.repository.employee;

import java.rmi.RemoteException;

import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.generics.GenericsDAO;

public interface EmployeeDAO extends GenericsDAO<Employee> {
	Employee findByName(String name) throws RemoteException;
}
