//package group.jpa.ogm.app;
//
//import group.jpa.ogm.app.controller.CustomerInterface;
//import group.jpa.ogm.app.entities.Customer;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class MainClient {
//    private static final String HOST = "192.168.1.7";
//    private static final int PORT = 9999;
//    private static Registry registry;
//
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        System.out.println("Connecting'");
//        registry = LocateRegistry.getRegistry(HOST,PORT);
//        CustomerInterface customerInterface = (CustomerInterface) registry.lookup(CustomerInterface.class.getSimpleName());
//        if(customerInterface!=null){
//            System.out.println("Got Server");
//        }
//        Customer customer = new Customer();
//        customer.setFullName("Nguyen Vu Khanh Huy");
//        customer.setPhone("0903718400");
//        System.out.println("add customer Name: "+customer.getFullName());
//        assert customerInterface != null;
//        customerInterface.addCustomer(customer);
////        Customer x =customerInterface.findCustomer("4800dd2e-5059-49aa-b7c1-e54f2b0591f9");
////        System.out.println("Name: "+x.getFullName());
//        System.out.println("Transaction ended");
//    }
//}
