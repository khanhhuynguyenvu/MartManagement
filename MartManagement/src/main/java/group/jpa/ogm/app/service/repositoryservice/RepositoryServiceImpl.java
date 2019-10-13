package group.jpa.ogm.app.service.repositoryservice;

import group.jpa.ogm.app.repository.customer.CustomerRepository;
import group.jpa.ogm.app.repository.goods.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
public class RepositoryServiceImpl implements  RepositoryService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GoodRepository productRepository;

    public CustomerRepository getCustomerRepository() {
        return this.customerRepository;
    }

    public GoodRepository getProductRepository() {
        return this.productRepository;
    }
}
