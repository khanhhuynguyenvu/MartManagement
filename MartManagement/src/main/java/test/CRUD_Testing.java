package test;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import group.jpa.ogm.app.config.Config;
import group.jpa.ogm.app.entities.Account;
import group.jpa.ogm.app.service.repositoryservice.RepositoryService;

public class CRUD_Testing {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	RepositoryService repositoryService = ctx.getBean(RepositoryService.class);

//	@Test
//	public void crud_Account_Employee() {
//		// Test
//		Employee em = new Employee();
//		em.setFullName("Nhan vien ten Luan");
//		em.setGender("Male");
//		String sDate = "1998-07-10";
//		Date birthdate = Date.valueOf(sDate);
//		em.setBirthdate(birthdate);
//		// Account
//		Account acc = new Account();
//		acc.setUsername("khanhhuy");
//		acc.setPassword("Xinhdep89232");
//		acc.setType(0);
//		acc.setStatus("On");
//		acc.setStartingDate(Date.valueOf("2019-10-17"));
//		em.setAccount(acc);
//		repositoryService.getAccountRepository().save(acc);
//		repositoryService.getEmployeeRepository().addEmpoyee(em);
//	}

	@Test
	public void find_AccountByName() {
		Account acc = repositoryService.getAccountRepository().findAcccountByUsername("khanhhuy");
//		assertThat(acc, null);
	}
}
