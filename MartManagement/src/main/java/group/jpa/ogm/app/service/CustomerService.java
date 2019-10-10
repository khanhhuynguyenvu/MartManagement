package group.jpa.ogm.app.service;

import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer(String id) {
        return repository.findCustomer(id);
    }

    public void save(Customer customer) {
        repository.save(customer);
    }

    public void remove(Customer customer) {
        repository.remove(customer);
    }

    public void update(Customer customer) {
        repository.update(customer);
    }
}
