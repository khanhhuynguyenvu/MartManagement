package group.jpa.ogm.app.repository.customer;

import group.jpa.ogm.app.entities.Customer;

public interface CustomerRepository {
     Customer findCustomer(String id);
     void save(Customer customer);
     void remove(Customer customer);
     void update(Customer customer);
}
