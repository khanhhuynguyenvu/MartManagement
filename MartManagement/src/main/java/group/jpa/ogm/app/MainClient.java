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

		ClientController callSerivce = new ClientController("172.16.0.101", 9999);


		Category category = new Category();
		category.setName("Nước uống");
		
		//callSerivce.getCategoryDAO().save(category);
		
		System.out.println("asdas: " + callSerivce.getCategoryDAO().findbyName("Nước uống"));
	

	
		System.out.println("Done!");
	}
	
}
