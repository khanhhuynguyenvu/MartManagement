package group.jpa.ogm.app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.helper.RegisterRMIHelper;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;

public class MainServer {
    private static final  int PORT = 9999;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try {
            InetAddress.getLocalHost();
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        } catch (UnknownHostException e) {
            System.err.println("Can't get information host");
        }
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        EntityManager entityManager = ctx.getBean(EntityManager.class);
        RegisterRMIHelper registerRMIHelper = RegisterRMIHelper.getInstance(PORT);
        registerRMIHelper.registerObject(EmployeeDAO.class.getSimpleName(),new EmployeeDAOImpl(entityManager));
        System.out.println("Server started");
    }
}
