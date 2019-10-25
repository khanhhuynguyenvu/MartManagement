package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Employee;

public class MainClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
    	ClientController callSerivce = new ClientController("192.168.1.7",9999);
    	Employee em = new Employee();
    	em.setFullName("Luan6");
    	em.setGender("Male");
    	callSerivce.getEmployeeDAO().save(em);
//    	Employee em1 = callSerivce.getEmployeeDAO().findByName("Luan");
//    	System.out.println(em1.getId()+" "+em1.getFullName()+" "+em1.getGender());
    	System.out.println("Done!");
    }
}
