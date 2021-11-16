package tn.esprit.spring.services;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Employe;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {

	@Autowired
	IEmployeService us;
	
	private static final Logger l=LogManager.getLogger(EmployeServiceImpl.class);
	
	@Test
	@Order(1)
	public void testretrieveAllEmployes(){
		l.debug("RETREIVING ALL EMPLOYEES");
		List<Employe> listEmployes =us.retrieveAllEmployes();
		Assertions.assertNotEquals(0,listEmployes.size());
		l.debug("EMPLOYEES RETREIVED SUCCESFULY");
	}

	@Test
	@Order(2)
	public void testAddEmploye() {
	l.debug("ADD CONTRACT TEST");
	Employe employe = new Employe() ;
	//employe.setReferenceEmploye((long) 1);
	employe.setNom("no name");
	employe.setPrenom("Amira");
	employe.setPassword("moezmoez");
	employe.setEmail("elmoez.amira@esprit.tn");
	employe.setActif(true);
	employe.setRole(Role.ADMINISTRATEUR);
	assertNotNull(employe);
	Employe saved=us.addEmploye(employe);	
	Assertions.assertEquals(employe,saved);
	l.debug("EMPLOYEE ADDED SUCCESFULY");
	}
	
	
	 @Test
	 @Order(3)
	public void testUpdateEmploye(){
		Employe ct = us.retrieveEmployeByID((long) 1);
		ct.setNom("El Moez");
		ct.setPrenom("Amira");
		ct.setPassword("moezmoez");
		ct.setEmail("elmoez.amira@esprit.tn");
		ct.setActif(true);
		ct.setRole(Role.ADMINISTRATEUR);
		List<Employe> listEmployes =us.retrieveAllEmployes();
		Employe saved=us.updateEmploye(ct);
		Assertions.assertNotEquals(ct,saved);
		
	} 

	@Test
	@Order(4)
	public void testRetrieveEmploye() {
	Employe u =  us.retrieveEmployeByID((long)1); 
	//Assertions.assertEquals(Long.parseLong("1"),u.getId());

}

	 @Test
	 @Order(5)
	public void testdeleteEmploye() {
    l.debug("TESTING DELETE CONTRACT");
	List<Employe> listEmployes =us.retrieveAllEmployes();
	Employe cc =listEmployes.get(listEmployes.size()-1);

	us.deleteEmployeBd(cc.getId());
	l.debug("EMPLOYEE DELETED SUCCESFULY");
	//Assertions.assertEquals(-1,a);
	} 	
}
