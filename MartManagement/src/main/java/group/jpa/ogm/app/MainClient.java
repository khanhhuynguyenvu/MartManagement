package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.entities.Good;

public class MainClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
    	ClientController callSerivce = new ClientController("192.168.1.39",9999);
    	
    	Account ac = new Account();
    	ac.setUsername("kiet");
    	ac.setPassword("123");
    	ac.setStartingDate(new Date());
    	ac.setStatus("Yes");
    	
    //	callSerivce.getAccountDAO().save(ac);
    	
    	Employee em = new Employee();
    	em.setFullName("Ronaldo Nguyen");
    	em.setGender("Male");
    	em.setAccount(ac);
    //	callSerivce.getEmployeeDAO().save(em);
//    	Employee em1 = callSerivce.getEmployeeDAO().findByName("Luan");
//    	System.out.println(em1.getId()+" "+em1.getFullName()+" "+em1.getGender());
    	
    	//System.out.println("find: " + callSerivce.getAccountDAO().findByUserName("demo1"));
    	
    	Good g = new Good();
    	
    	g.setName("Coca cola");
    	g.setQuantity(5);
    	g.setPrice((double) 5000);
    	g.setEnterDate(new Date());
    	
    	Account ac1 = new Account();
    	ac1.setId("b04e88a4-ed7b-4863-949a-2de428a744cc");
    	
    	callSerivce.getAccountDAO().remove(ac1);
    	
    //	callSerivce.getGoodDAO().save(g);
    	
    //	System.out.println("find Good: " + callSerivce.getGoodDAO().findByProductKey("L"));
    	
    	System.out.println("Done!");
    	
    	
    }
}
