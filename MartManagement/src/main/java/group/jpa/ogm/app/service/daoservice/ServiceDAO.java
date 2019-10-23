package group.jpa.ogm.app.service.daoservice;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.account.AccountDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;

public interface ServiceDAO {
	EmployeeDAO getEmployeeDAO();
}
