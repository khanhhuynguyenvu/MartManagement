package group.jpa.ogm.app.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;
import group.jpa.ogm.app.service.daoservice.ServiceDAO;

public interface DAOControllerInterface extends Remote {
	Employee findEmp(String id) throws RemoteException;
	EmployeeDAO getEmployeeDAO() throws RemoteException;
}
