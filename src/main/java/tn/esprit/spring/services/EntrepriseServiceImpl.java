package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.EntrepriseDTO;
import tn.esprit.spring.services.EntrepriseConverter;
import org.apache.log4j.Logger;
import tn.esprit.spring.repository.EntrepriseRepository;
import org.apache.log4j.LogManager;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
    EntrepriseConverter converter;
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	
	
	@Transactional
	public Integer ajouterEntreprise(EntrepriseDTO entreprise) {
		
		try{
			l.info("started ajouterEntreprise()");
			Entreprise en = converter.entrepriseTodo(entreprise);
			entrepriseRepoistory.save(en);
			l.debug("entreprise added with id = "+entreprise.getId());
			l.info("finished ajouterEntreprise()");
			return entreprise.getId();
		} catch (Exception e) {
			l.error("error executing ajouterEntreprise() :"+e);
			return null;
		}	
		
	}

	
	@Transactional
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> depNames = new ArrayList<>();
		try{
			l.info("started getAllDepartementsNamesByEntreprise() : ");
			Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
			if(entrepriseManagedEntity.isPresent()) {
				for(Departement dep : entrepriseManagedEntity.get().getDepartements()){
					depNames.add(dep.getName());
				}
			}
			l.debug("fetching departements");
			l.info("finished getAllDepartementsNamesByEntreprise() ");
			return depNames;
		} catch (Exception e) {
			l.error("error executing getAllDepartementsNamesByEntreprise() :"+e);
			depNames.clear();
			return depNames;
		}
		
	}

	@Transactional
	public Integer deleteEntrepriseById(int entrepriseId) {
		try {
			l.info("started deleteEntrepriseById() ");
			Optional<Entreprise> entreprise=entrepriseRepoistory.findById(entrepriseId);
			if (entreprise.isPresent()) {
				entrepriseRepoistory.delete(entreprise.get());	
			} 
			l.debug("Deleted entreprise with id = "+entrepriseId);
			l.info("finished deleteEntrepriseById()");
			return 1;
		} catch (Exception e) {
			l.error("error executing deleteEntrepriseById() :" + e);
			return 0;
		}
	}
	

	@Transactional
	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise en = null;
		try {
			l.info("started getEntrepriseById() : ");
			Optional<Entreprise> entreprise = entrepriseRepoistory.findById(entrepriseId);
			if (entreprise.isPresent()) {
				en=entreprise.get();
			}
			l.debug("fetching entreprise by id");
			l.info("finished getEntrepriseById() ");
			return en;
		} catch (Exception e) {
			l.error("error executing deleteEntrepriseById() :" + e);
			return null;
		}
	}
	
	
}
