package group.jpa.ogm.app.repository.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import group.jpa.ogm.app.entities.Employee;

@Repository
public class EmployeerRepositoryImpl implements EmployeeRepository {
	@Autowired
	EntityManager entityManager;

	public void addEmpoyee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}

	public Employee findEmployee(String id) {
		return entityManager.find(Employee.class, id);
	}

	public void deleteEmpoyee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(employee);
		transaction.commit();
	}

	public void updateEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(employee);
		transaction.commit();
	}

}
