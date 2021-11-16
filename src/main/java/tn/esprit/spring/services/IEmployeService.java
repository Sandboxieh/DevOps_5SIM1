package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService { 
	 
	List<Employe> retrieveAllEmployes(); 
	Employe addEmploye(Employe u);
	public void deleteEmployeBd(Long id);
	Employe updateEmploye(Employe u);
	public Employe retrieveEmployeByID(Long id);

} 
 