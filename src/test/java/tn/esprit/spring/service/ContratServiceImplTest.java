package tn.esprit.spring.service;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import tn.esprit.spring.TimesheetApplication;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.repository.ContratRepository;
import java.util.List;

@ContextConfiguration(classes = TimesheetApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContratServiceImpl.class)
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest {
	
	static final Logger l = LogManager.getLogger(ContratServiceImplTest.class);
	@Autowired
	IContratService cs;
	ContratRepository cr;
	

		@Test
		@Order(1)
		public void testretrieveAllContrats(){
			l.debug("RETREIVING ALL CONTRACTs");
			List<Contrat> listContrats =cs.retrieveAllContrats();
			Assertions.assertNotEquals(0,listContrats.size());
			l.debug("CONTRACTS RETREIVED SUCCESFULY");
		}

		@Test
		@Order(2)
		public void testAddContrat() {
		l.debug("ADD CONTRACT TEST");
		Contrat contrat = new Contrat() ;
		//contrat.setReferenceContrat((long) 1);
		contrat.setDateDebutContrat(null);
		contrat.setTypeContrat("CDI");
		contrat.setSalaire(1500);
		assertNotNull(contrat);
		Contrat u_saved=cs.addContrat(contrat);	
		Assertions.assertEquals(contrat,u_saved);
		l.debug("CONTRAT ADDED SUCCESFULY");
		}
		
		
		 @Test
		 @Order(3)
		public void testUpdateContrat(){
			Contrat ct = cs.retrieveContratByID((long) 1);
			ct.setTypeContrat("UPDATED");
			ct.setDateDebutContrat(new java.util.Date());
			Contrat cc =listContrats.get(listContrats.size()-1);
			ct.setSalaire((cc.getReferenceContrat()-1)*100);
			Contrat u_saved=cs.updateContrat(ct);
			Assertions.assertNotEquals(ct,u_saved);
			
		} 

		@Test
		@Order(4)
		public void testRetrieveContrat() {
		Contrat u =  cs.retrieveContratByID((long)1); 
		Assertions.assertEquals(Long.parseLong("1"),u.getReferenceContrat());

	}

		 @Test
		 @Order(5)
		public void testdeleteContrat() {
	    l.debug("TESTING DELETE CONTRACT");
		List<Contrat> listContrats =cs.retrieveAllContrats();
		Contrat cc =listContrats.get(listContrats.size()-1);
	
		cs.deleteContratById(cc.getReferenceContrat());
		l.debug("CONTRACT DELETED SUCCESFULY");
		//Assertions.assertEquals(-1,a);
		} 
	

}
