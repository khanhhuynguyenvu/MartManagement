package group.jpa.ogm.app.repository.customer;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Customer;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

@Component
public class CustomerDAOImpl extends GenericsDAOImpl<Customer> implements CustomerDAO {
}
