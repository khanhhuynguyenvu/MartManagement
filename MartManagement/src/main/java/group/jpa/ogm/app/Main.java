package group.jpa.ogm.app;

import group.jpa.ogm.app.controller.CustomerController;
import group.jpa.ogm.app.entities.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setFirstName("Nguyen Vu Khanh Huy");
        CustomerController controller = new CustomerController();
        controller.addCustomer(customer);
        System.out.println("Done");
    }
}
