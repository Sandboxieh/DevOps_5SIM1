package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.EntrepriseDTO;

public interface IEntrepriseService {
	
	public Integer ajouterEntreprise(EntrepriseDTO entreprise);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public Integer deleteEntrepriseById(int entrepriseId);
	public Entreprise getEntrepriseById(int entrepriseId);
	
}
