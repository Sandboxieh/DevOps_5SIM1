package tn.esprit.spring.services;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;
import java.util.List;

@Repository
public interface IContratService {

	public Contrat addContrat(Contrat contrat);
	public void deleteContratById(Long id );
	public List<Contrat> retrieveAllContrats();
	Contrat updateContrat(Contrat c);
	public Contrat retrieveContratByID(Long id);
}
