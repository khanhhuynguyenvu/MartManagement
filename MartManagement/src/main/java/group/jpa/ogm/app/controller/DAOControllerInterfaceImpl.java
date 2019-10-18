package group.jpa.ogm.app.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;
import group.jpa.ogm.app.service.daoservice.ServiceDAO;

public class DAOControllerInterfaceImpl extends UnicastRemoteObject implements DAOControllerInterface {
	private static final long serialVersionUID = 1L;
	private ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	private ServiceDAO daoService = ctx.getBean(ServiceDAO.class);

	public DAOControllerInterfaceImpl() throws RemoteException {
	}

	public Employee findEmp(String id) throws RemoteException{
		return daoService.getEmployeeDAO().findById(id, Employee.class);
	}

	public EmployeeDAO getEmployeeDAO(){
		return this.daoService.getEmployeeDAO();
	}
}
