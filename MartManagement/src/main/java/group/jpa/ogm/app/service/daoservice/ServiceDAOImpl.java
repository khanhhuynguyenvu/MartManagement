package group.jpa.ogm.app.service.daoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jpa.ogm.app.repository.employee.EmployeeDAO;

@Service
public class ServiceDAOImpl implements ServiceDAO {
	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeDAO getEmployeeDAO() {
		return this.employeeDAO;
	}

}
