package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.entities.Good;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
		ClientController callSerivce = new ClientController("192.168.31.22", 9999);

	

		Good g = new Good();
		g.setName("Lavie");	
		g.setEnterDate(new Date());	//	SimpleDateFormat ft =  new SimpleDateFormat ("E yyyy.MM.dd");	
		g.setPrice((double) 5000);
		g.setQuantity(10);
		
	//	callSerivce.getGoodDAO().save(g);
		
		System.out.println("find by name: " + callSerivce.getCategoryDAO().findbyName("Nước giải khát"));
		
		
		
		
		
		
	
		System.out.println("Done!");
	}
}
