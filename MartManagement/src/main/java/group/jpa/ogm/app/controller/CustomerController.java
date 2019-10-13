package group.jpa.ogm.app.controller;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.service.repositoryservice.RepositoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CustomerController extends UnicastRemoteObject implements CustomerInterface {
    private ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    private RepositoryService repositoryService = ctx.getBean(RepositoryService.class);

    public CustomerController() throws RemoteException {
    }

    public void addCustomer(Customer customer) {
        repositoryService.getCustomerRepository().save(customer);
    }

    public void addProduct(Good good) {
        repositoryService.getProductRepository().save(good);
    }

    public Customer findCustomer(String id) {
        return repositoryService.getCustomerRepository().findCustomer(id);
    }

}
