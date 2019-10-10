package group.jpa.ogm.app;

import group.jpa.ogm.app.controller.CustomerController;
import group.jpa.ogm.app.entities.Customer;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//        CustomerService service = ctx.getBean(CustomerService.class);
        Customer customer = new Customer();
        customer.setFirstName("Nguyen Vu Khanh Huy");
//        service.save(customer);
        CustomerController controller = new CustomerController();
        controller.addCustomer(customer);
        System.out.println("Done");
    }
}
