package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
>>>>>>> 493fd53b1ca3ac8a8188dc2afd53fdd9e702d2ec
import java.util.Date;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.entities.Good;

public class MainClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
<<<<<<< HEAD
		ClientController callSerivce = new ClientController("192.168.1.4", 9999);
=======
		ClientController callSerivce = new ClientController(" 172.16.0.164", 9999);
>>>>>>> 493fd53b1ca3ac8a8188dc2afd53fdd9e702d2ec

	

<<<<<<< HEAD
		account1.setUsername("luan");
		account1.setPassword("1");
		account1.setType(1);
		
		
		Employee em = new Employee();
		em.setFullName("Luan");
		em.setGender("Male");
		em.setBirthdate(new Date());
		em.setAddress("AddressNVB");
		em.setAccount(account1);
	
//		callSerivce.getEmployeeDAO().save(em);
//	
		
//		System.out.println("x: " + callSerivce.getAccountDAO().findByUserName("ac1").getUsername());
//		System.out.println("x: " + callSerivce.getAccountDAO().findByUserName("ac2").getUsername());
//		
//		System.out.println(callSerivce.getAccountDAO().CheckMatKhauCu("1", "1"));
//		
//		
//		System.out.println(account1.getPassword());
//		System.out.println(callSerivce.getAccountDAO().doiMatKhau(account1, "123"));
//		System.out.println(account1.getPassword());
		
		
=======
		Good g = new Good();
		g.setName("Aquafina");	
		g.setEnterDate(new Date());	//	SimpleDateFormat ft =  new SimpleDateFormat ("E yyyy.MM.dd");	
		g.setPrice((double) 5000);
		g.setQuantity(5);
		
	//	callSerivce.getGoodDAO().save(g);
		
		
		System.out.println("list: " + callSerivce.getGoodDAO().fillAll());
		
	
>>>>>>> 493fd53b1ca3ac8a8188dc2afd53fdd9e702d2ec
		System.out.println("Done!");
	}
	
}
