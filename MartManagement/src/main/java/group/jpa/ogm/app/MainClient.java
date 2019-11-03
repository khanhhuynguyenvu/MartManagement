	package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Category;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.entities.Good;

public class MainClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {

		ClientController callSerivce = new ClientController("192.168.1.40", 9999);

		
		Account ac = new Account();
		ac.setUsername("luan");
		ac.setPassword("1");
		ac.setStartingDate(new Date());
		ac.setStatus("Active");
		ac.setType(1);
		
		Employee em = new Employee();
		em.setAccount(ac);
		em.setFullName("N Thanh Luan");
		em.setGender("male");
		em.setBirthdate(new Date());
		em.setAddress("LA");
		
		callSerivce.getEmployeeDAO().save(em);
	
		//callSerivce.getAccountDAO().save(ac);
	
		System.out.println("Done!");
	}
	
}
