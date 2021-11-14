package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.DepartementDTO;


public interface IDepartementService {
	
	
	public List<Departement> getAllDepartements();
	
	
	public Integer ajouterDepartement(DepartementDTO dep);

	public Departement affecterDepartementAEntreprise(int depId, int entrepriseId);
	
	public Integer deleteDepartementById(int depId);

	public Departement getDepartmentById(int departmentId) ;

	public Departement desaffecterDepartementDuEntreprise (int depId , int entId);

		
}