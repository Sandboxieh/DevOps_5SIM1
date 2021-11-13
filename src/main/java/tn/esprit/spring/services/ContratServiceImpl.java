package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;
	private static final Logger L = LogManager.getLogger(ContratServiceImpl.class);

	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			
			L.info("In Method retrieveAllContrats :");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat : contrats) {
				L.debug("connexion à la DB OK :");
				  
			} 
			L.info("Out of Method retrieveAllContrats with Sucess");
		}catch (Exception e) {
			L.error("Out of Method retrieveAllContrats with Erroes : " +e);
		}

		return contrats;
	}


}
