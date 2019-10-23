package group.jpa.ogm.app.service.daoservice;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.repository.account.AccountDAO;
import group.jpa.ogm.app.repository.employee.EmployeeDAO;

@Service
public class ServiceDAOImpl implements Serializable,ServiceDAO {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeDAO getEmployeeDAO() {
		return this.employeeDAO;
	}

}
