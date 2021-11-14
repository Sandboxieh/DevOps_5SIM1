package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;
	static final Logger L = LogManager.getLogger(ContratServiceImpl.class);
	@Override
	public Contrat ajouterContrat(Contrat contrat) {
	
		contratRepository.save(contrat);
		
		return contrat;
	}

	@Override
	public void deleteContratById(Long id) {

		
		contratRepository.deleteById(id);
	}

	 @Override
	public List<Contrat> retrieveAllContrats(){
	List<Contrat> contrat = (List<Contrat>) contratRepository.findAll();

	for (Contrat c : contrat){
		L.info("c +++ :" + c);
	}
	return contrat;

	} 

	@Override
	public Contrat updateContrat(Contrat c) {
		
		return contratRepository.save(c);
	}
	@Override	
	public  Optional<Contrat> findById(Long idContrat){
		 return contratRepository.findById(idContrat);
		
	}
}
