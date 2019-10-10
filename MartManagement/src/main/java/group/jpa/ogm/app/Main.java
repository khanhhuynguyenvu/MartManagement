package group.jpa.ogm.app;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.controller.CustomerController;
import group.jpa.ogm.app.entities.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//        CustomerService service = ctx.getBean(CustomerService.class);
        Customer customer = new Customer();
        customer.setFirstName("Nguyen Vu Khanh Huy Hehe");
//        service.save(customer);
        CustomerController controller = new CustomerController();
        controller.TestAddCustomer(customer);
        System.out.println("Done");
    }
}
