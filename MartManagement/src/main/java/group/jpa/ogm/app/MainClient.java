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
    	ClientController callSerivce = new ClientController();
    	Employee em = new Employee();
    	em.setFullName("Nhan vien ten Luannnnnnnnnnn");
    	em.setGender("Male");
    	callSerivce.getEmployeeDAO().save(em);
    }
}
