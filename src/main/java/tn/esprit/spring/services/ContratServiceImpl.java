package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.repository.ContratRepository;
import java.util.List;


@Transactional
@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;
	static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	@Override
	public Contrat addContrat(Contrat contrat) {
	
		l.info("In addContract() : ");
		Contrat saved = contratRepository.save(contrat); 
		l.info("Out of addContract() : saved Contract: "+saved);
		return saved; 
	}

	@Override
	public void deleteContratById(Long id) {

		
		l.info("In deleteContrat() : ");
		contratRepository.deleteById(id);
		
		l.info("Out of deleteContrat() : deleted Contract id : "+id);
		
	}
	

	 @Override
	public List<Contrat> retrieveAllContrats(){
	List<Contrat> contrats = null; 
		try {
	
			l.info("In retrieveAllContrats() ");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat Contrat : contrats) {
				l.debug("Contrat +++: "+Contrat);
			} 
			l.info("Out of retrieveAllContrats() with success ");
		}catch (Exception e) {
			l.error("Error in  retrieveAllContrats() with Error: "+ e);
		}

		return Contrats;
	} 

	@Override
	public Contrat updateContrat(Contrat c) {
		l.info("In updateContract() : ");
		Contrat saved = contratRepository.save(c); 
		l.info("Out of updateContract() : updated Contract: "+saved);
		return saved; 
	}

	@Override
	public Contrat retrieveContratByID(Long id) {
		l.info("In retrieveContratByID() : ");
		Contrat u =  contratRepository.findById(id).orElse(new Contrat()); 
		l.info("Out of retrieveContratByID() : found Contract : "+u);
		return u; 
	}
}
