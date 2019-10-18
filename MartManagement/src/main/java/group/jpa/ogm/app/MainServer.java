package group.jpa.ogm.app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import group.jpa.ogm.app.helper.RegisterRMIHelper;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAOImpl;

public class MainServer {
    private static final  int PORT = 9999;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try {
            InetAddress.getLocalHost();
            System.setProperty("java.rmi.server.hostname", "192.168.1.6");
        } catch (UnknownHostException e) {
            System.err.println("Can't get information host");
        }
        RegisterRMIHelper registerRMIHelper = RegisterRMIHelper.getInstance(PORT);
        registerRMIHelper.registerObject(EmployeeDAO.class.getSimpleName(),new EmployeeDAOImpl());
        System.out.println("Server started");
    }
}
