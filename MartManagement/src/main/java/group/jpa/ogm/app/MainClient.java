package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
		ClientController callSerivce = new ClientController("172.16.0.173", 9999);

		Account account1 = new Account();

		account1.setUsername("ac1");
		account1.setPassword("123465");
		account1.setType(1);

		Employee em = new Employee();
		em.setFullName("Luan111");
		em.setGender("Male");
		em.setAccount(account1);

		callSerivce.getAccountDAO().save(account1);

		//callSerivce.getEmployeeDAO().save(em);
		
		System.out.println("x: " + callSerivce.getAccountDAO().findByUserName("ac1").getUsername());

		System.out.println("Done!");
	}
}
