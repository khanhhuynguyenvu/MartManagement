package group.jpa.ogm.app.controller;

import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.entities.Good;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CustomerInterface extends Remote {
    void addCustomer(Customer customer) throws RemoteException;
    void addProduct(Good good) throws RemoteException;
    Customer findCustomer(String id) throws RemoteException;
}
