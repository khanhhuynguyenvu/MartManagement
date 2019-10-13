package group.jpa.ogm.app.service.repositoryservice;

import group.jpa.ogm.app.repository.customer.CustomerRepository;
import group.jpa.ogm.app.repository.goods.GoodRepository;

import java.rmi.Remote;

public interface RepositoryService {
    CustomerRepository getCustomerRepository();
    GoodRepository getProductRepository();
}
