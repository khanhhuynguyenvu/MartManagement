package group.jpa.ogm.app.service.repositoryservice;

import group.jpa.ogm.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl implements  RepositoryService {
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerRepository getCustomerRepository() {
        return this.customerRepository;
    }
}
