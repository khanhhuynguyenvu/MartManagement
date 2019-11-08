package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import group.jpa.ogm.app.controller.client.ClientController;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.entities.Category;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.entities.Invoice;
import group.jpa.ogm.app.entities.InvoiceDetails;

public class MainClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
		ClientController call = new ClientController("192.168.31.22", 9999);
		
		System.out.println("tesst: " + call.getInvoiceDAO().getLastInvoiceByDate());
		System.out.println("find by id: ");
		InvoiceDetails inD = call.getInvoiceDetailsDAO().findByInvoiceId(call.getInvoiceDAO().getLastInvoiceByDate().getId());
		
		
		
		
	}

}
