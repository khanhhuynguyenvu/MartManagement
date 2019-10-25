package group.jpa.ogm.app.service.daoservice;

import java.io.Serializable;

import group.jpa.ogm.app.repository.employee.EmployeeDAO;

public class ServiceDAOImpl implements Serializable,ServiceDAO {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public EmployeeDAO getEmployeeDAO() {
		return this.employeeDAO;
	}

}
