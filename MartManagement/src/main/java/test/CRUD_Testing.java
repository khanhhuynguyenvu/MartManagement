//package test;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import group.jpa.ogm.app.config.Config;
//import group.jpa.ogm.app.entities.Account;
//import group.jpa.ogm.app.entities.Employee;
//import group.jpa.ogm.app.service.repositoryservice.RepositoryService;
//
//public class CRUD_Testing {
//	ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//	RepositoryService repositoryService = ctx.getBean(RepositoryService.class);
//
//	@Test
//	public void crud_Account_Employee() throws ParseException {
//		// Test
//		Employee em = new Employee();
//		em.setFullName("Nhan vien ten Luan");
//		em.setGender("Male");
//		String sDate1="17/10/2019";  
//	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
//		em.setBirthdate(date1);
//		// Account
//		Account acc = new Account();
//		acc.setUsername("khanhhuy");
//		acc.setPassword("Xinhdep89232");
//		acc.setType(0);
//		acc.setStatus("On");
//		acc.setStartingDate(date1);
//		em.setAccount(acc);
//		repositoryService.getAccountRepository().save(acc);
//		repositoryService.getEmployeeRepository().addEmpoyee(em);
//	}
//
//	@Test
//	public void find_AccountByName() {
//		List<Account> acc = repositoryService.getAccountRepository().findAcccountByUsername("khanhhuy");
//		assertNotNull(acc);
//	}
//}
