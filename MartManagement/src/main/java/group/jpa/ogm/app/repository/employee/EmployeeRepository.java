package group.jpa.ogm.app.repository.employee;

import group.jpa.ogm.app.entities.Employee;

public interface EmployeeRepository {
	void addEmpoyee(Employee employee);
	Employee findEmployee(String id);
	void deleteEmpoyee(Employee employee);
	void updateEmployee(Employee employee);
}
