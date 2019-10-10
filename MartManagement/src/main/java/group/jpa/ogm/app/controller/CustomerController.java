package group.jpa.ogm.app.controller;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerController {
//    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//    private CustomerService customerService = ctx.getBean(CustomerService.class);
    @Autowired
    CustomerService customerService;
    public void TestAddCustomer(Customer customer){
        customerService.save(customer);
    }

    public CustomerController() {
    }
}
