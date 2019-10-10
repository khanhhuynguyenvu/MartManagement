package group.jpa.ogm.app.controller;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerController {
    private ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    private CustomerService customerService = ctx.getBean(CustomerService.class);

    public void addCustomer(Customer customer){
        customerService.save(customer);
    }

    public CustomerController() {
    }
}
