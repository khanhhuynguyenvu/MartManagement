package group.jpa.ogm.app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Invoice;
import group.jpa.ogm.app.helper.RegisterRMIHelper;
import group.jpa.ogm.app.repository.account.AccountDAO;
import group.jpa.ogm.app.repository.account.AccountDAOImpl;
import group.jpa.ogm.app.repository.customer.CustomerDAO;
import group.jpa.ogm.app.repository.customer.CustomerDAOImpl;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAOImpl;
import group.jpa.ogm.app.repository.goods.GoodDAO;
import group.jpa.ogm.app.repository.goods.GoodDAOImpl;
import group.jpa.ogm.app.repository.invoice.InvoiceDAO;
import group.jpa.ogm.app.repository.invoice.InvoiceDAOImpl;
import group.jpa.ogm.app.repository.invoiceDetails.InvoiceDetailsDAO;
import group.jpa.ogm.app.repository.invoiceDetails.InvoiceDetailsDAOImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;

public class MainServer {
    private static final  int PORT = 9999;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try {
            InetAddress.getLocalHost();
            System.setProperty("java.rmi.server.hostname", "172.16.0.164");
        } catch (UnknownHostException e) {
            System.err.println("Can't get information host");
        }
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        EntityManager entityManager = ctx.getBean(EntityManager.class);
        RegisterRMIHelper registerRMIHelper = RegisterRMIHelper.getInstance(PORT);
        
        registerRMIHelper.registerObject(EmployeeDAO.class.getSimpleName(),new EmployeeDAOImpl(entityManager));
        registerRMIHelper.registerObject(CustomerDAO.class.getSimpleName(),new CustomerDAOImpl(entityManager));
        registerRMIHelper.registerObject(AccountDAO.class.getSimpleName(), new AccountDAOImpl(entityManager));
        registerRMIHelper.registerObject(GoodDAO.class.getSimpleName(), new GoodDAOImpl(entityManager));
        registerRMIHelper.registerObject(InvoiceDAO.class.getSimpleName(), new InvoiceDAOImpl(entityManager));
        registerRMIHelper.registerObject(InvoiceDetailsDAO.class.getSimpleName(), new InvoiceDetailsDAOImpl(entityManager));
        
        System.out.println("Server started");
    }
}
