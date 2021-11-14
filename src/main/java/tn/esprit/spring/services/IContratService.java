package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.ContratDTO;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public Integer ajouterContrat(ContratDTO contrat);
	public int deleteContratById(int contratId);
	public void deleteAllContratJPQL();
	
}
