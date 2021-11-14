package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.ContratDTO;
import tn.esprit.spring.services.IContratService;

@Controller
public class ControllerContratImpl {

	@Autowired
	IContratService contartservice;
	
	
	public int ajouterContrat(ContratDTO contrat) {
		return contartservice.ajouterContrat(contrat);
	}
	
	public void deleteContratById(int contratId) {
		contartservice.deleteContratById(contratId);
	}
	
	public void deleteAllContratJPQL() {
		contartservice.deleteAllContratJPQL();

	}
}
