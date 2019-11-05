	package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
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

		ClientController callSerivce = new ClientController("192.168.88.25", 9999);

		Account ac = new Account();
		ac.setUsername("l");
		ac.setPassword("1");
		ac.setStartingDate(new Date());
		ac.setStatus("Yes");
		ac.setType(1);


		Employee em = new Employee();
		em.setFullName("Ronaldo Nguyen");
		em.setGender("Male");
		em.setAddress("NVB");
		em.setBirthdate(new Date());
		em.setAccount(ac);
		
		//callSerivce.getEmployeeDAO().save(em);
		
		System.out.println("DONE");
		
	}
	
}
