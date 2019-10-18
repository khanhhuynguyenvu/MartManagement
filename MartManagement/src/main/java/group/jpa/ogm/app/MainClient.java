package group.jpa.ogm.app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;

import group.jpa.ogm.app.controller.client.ClientController;

public class MainClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, ParseException {
    	ClientController.lookUpDAOClass();
    }
}
