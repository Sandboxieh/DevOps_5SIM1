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

import tn.esprit.spring.TimesheetApplication;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.repository.ContratRepository;

@ContextConfiguration(classes = TimesheetApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContratServiceImpl.class)
public class ContratServiceImplTest {
	private static final long DEFAULT_TIMEOUT = 10000;
	static final Logger l = LogManager.getLogger(ContratServiceImplTest.class);
	@Autowired
	IContratService cs;
	ContratRepository cr;
	
		@Test
		public void testAjouterContrat() {
		Contrat contrat = new Contrat() ;
		//contrat.setReferenceContrat((long) 1);
		contrat.setDateDebutContrat(null);
		contrat.setTypeContrat("CDI");
		contrat.setSalaire(1500);
		assertNotNull(contrat);
		cs.ajouterContrat(contrat);	
		}
	
		
	
		@Test
		public void testretrieveAllContrats(){
			cs.retrieveAllContrats();
		}
		 
		
		
		/* @Test
		public void testUpdateContrat(){
			Contrat ct = cs.findById((long) 2).get();
			ct.setTypeContrat("UPDATED");
			ct.setDateDebutContrat(null);
			ct.setSalaire(1500);
			cr.deleteById((long)2);
			cr.save(ct);
		} */

		 @Test
		public void testdeleteContrat() {
	
		cs.deleteContratById((long) 2);
		
		} 
	

}
