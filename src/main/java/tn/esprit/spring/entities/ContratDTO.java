package tn.esprit.spring.entities;


import java.util.Date;

import lombok.Data;
@Data
public class ContratDTO {
	private  Date dateDebut;
	private String typeContrat;
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	private float salaire;
	public ContratDTO(Date dateDebut, String typeContrat, float salaire) {
		super();
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}
	public ContratDTO() {
		super();
		
	}
	
	
}
