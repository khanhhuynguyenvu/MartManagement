package test;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Employee;
import group.jpa.ogm.app.service.daoservice.ServiceDAO;	

public class CRUD_NEW_Testing {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	ServiceDAO repositoryService = ctx.getBean(ServiceDAO.class);

	@Test
	public void saveEmployee_FromGenericsType() throws ParseException {
		Employee em = new Employee();
		em.setFullName("Nhan vien ten Kiet");
		em.setGender("Male");
		String sDate1="17/10/2019";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
		em.setBirthdate(date1);
		repositoryService.getEmployeeDAO().save(em);
	}
	@Test
	public void findEmployeeById() {
		Employee em = repositoryService.getEmployeeDAO().findById("dc9c3148-0ec7-4988-b10b-3ff048a5e682",Employee.class);
		System.out.println(em.getFullName());
		assertNotNull(em);
	}
}
