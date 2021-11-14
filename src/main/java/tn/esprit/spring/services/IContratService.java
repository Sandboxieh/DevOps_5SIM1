package tn.esprit.spring.services;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;
import java.util.List;
import java.util.Optional;

@Repository
public interface IContratService {

	public Contrat ajouterContrat(Contrat contrat);
	public void deleteContratById(Long id );
	public List<Contrat> retrieveAllContrats();
	Contrat updateContrat(Contrat c);
	Optional<Contrat> findById(Long idContrat);
}
