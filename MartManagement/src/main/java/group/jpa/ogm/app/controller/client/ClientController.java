package group.jpa.ogm.app.controller.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;

public class ClientController {
	private static final String HOST = "192.168.1.6";
	private static final int PORT = 9999;
	private static Registry registry;

	public static void lookUpDAOClass() throws RemoteException, NotBoundException {
		System.out.println("Client Connecting'");
		registry = LocateRegistry.getRegistry(HOST, PORT);
//		DAOControllerInterface call = (DAOControllerInterface) registry.lookup(DAOControllerInterface.class.getSimpleName());
		EmployeeDAO call = (EmployeeDAO) registry.lookup(EmployeeDAO.class.getSimpleName());
		System.out.println("Name : "+call.findById("9198153a-ddc6-4913-8835-f46fa1e031bd",Employee.class).getFullName());
		System.out.println("Client end connection!");
	}
}
