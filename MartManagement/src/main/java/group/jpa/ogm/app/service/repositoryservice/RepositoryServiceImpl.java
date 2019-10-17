package group.jpa.ogm.app.service.repositoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jpa.ogm.app.repository.account.AccountRepository;
import group.jpa.ogm.app.repository.customer.CustomerRepository;
import group.jpa.ogm.app.repository.employee.EmployeeRepository;
import group.jpa.ogm.app.repository.goods.GoodRepository;

@Service
public class RepositoryServiceImpl implements  RepositoryService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GoodRepository productRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountRepository accountRepository;

    public CustomerRepository getCustomerRepository() {
        return this.customerRepository;
    }

    public GoodRepository getProductRepository() {
        return this.productRepository;
    }

	public EmployeeRepository getEmployeeRepository() {
		return this.employeeRepository;
	}

	public AccountRepository getAccountRepository() {
		return this.accountRepository;
	}
    
}
