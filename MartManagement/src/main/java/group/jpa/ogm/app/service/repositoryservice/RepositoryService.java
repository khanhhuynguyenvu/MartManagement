package group.jpa.ogm.app.service.repositoryservice;

import group.jpa.ogm.app.repository.account.AccountRepository;
import group.jpa.ogm.app.repository.customer.CustomerRepository;
import group.jpa.ogm.app.repository.employee.EmployeeRepository;
import group.jpa.ogm.app.repository.goods.GoodRepository;

public interface RepositoryService {
    CustomerRepository getCustomerRepository();
    GoodRepository getProductRepository();
    EmployeeRepository getEmployeeRepository();
    AccountRepository getAccountRepository();
}
