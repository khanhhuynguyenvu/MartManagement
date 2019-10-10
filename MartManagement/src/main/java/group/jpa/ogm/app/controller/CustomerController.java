package group.jpa.ogm.app.controller;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.service.repositoryservice.RepositoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerController {
    private ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    private RepositoryService repositoryService = ctx.getBean(RepositoryService.class);
    public void addCustomer(Customer customer){
        repositoryService.getCustomerRepository().save(customer);
    }

    public CustomerController() {
    }
}
