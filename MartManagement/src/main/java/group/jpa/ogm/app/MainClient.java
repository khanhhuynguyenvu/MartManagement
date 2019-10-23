package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
    	ClientController callSerivce = new ClientController("172.16.0.236",9999);
//    	Employee em = new Employee();
//    	em.setFullName("Luan");
//    	em.setGender("Male");
//    	callSerivce.getEmployeeDAO().save(em);
    	Employee em = callSerivce.getEmployeeDAO().findByName("Luan");
    	System.out.println(em.getId()+" "+em.getFullName()+" "+em.getGender());
    	System.out.println("Done!");
    }
}
