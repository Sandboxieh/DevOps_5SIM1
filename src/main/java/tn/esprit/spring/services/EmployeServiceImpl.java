package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l=LogManager.getLogger(EmployeServiceImpl.class);
	
	@Override
	public Employe addEmploye(Employe employe) {
	
		l.info("In addEmploye() : ");
		Employe saved = employeRepository.save(employe); 
		l.info("Out of addEmploye() : saved Employe: "+saved);
		return saved; 
	}

	@Override
	public void deleteEmployeBd(Long id) {

		
		l.info("In deleteEmploye() : ");
		employeRepository.deleteById(id);
		
		l.info("Out of deleteEmploye() : deleted Employe id : "+id);
		
	}
	

	 @Override
	public List<Employe> retrieveAllEmployes(){
	List<Employe> employes = null; 
		try {
	
			l.info("In retrieveAllEmployes() ");
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe Employe : employes) {
				l.debug("Employe +++: "+Employe);
			} 
			l.info("Out of retrieveAllEmployes() with success ");
		}catch (Exception e) {
			l.error("Error in  retrieveAllEmployes() with Error: "+ e);
		}

		return employes;
	} 

	@Override
	public Employe updateEmploye(Employe c) {
		l.info("In updateEmploye() : ");
		Employe saved = employeRepository.save(c); 
		l.info("Out of updateContract() : updated Employe: "+saved);
		return saved; 
	}

	@Override
	public Employe retrieveEmployeByID(Long id) {
		l.info("In retrieveEmployeByID() : ");
		Employe u =  employeRepository.findById(id).orElse(new Employe()); 
		l.info("Out of retrieveEmployeByID() : found Employe : "+u);
		return u; 
	}


}
