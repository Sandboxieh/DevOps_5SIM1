package tn.esprit.spring.entities;

import lombok.Data;


@Data
public class EntrepriseDTO {
	  private int id;
	  private String name;
	  private String raisonSocial;
	  
	  public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRaisonSocial() {
			return raisonSocial;
		}

		public void setRaisonSocial(String raisonSocial) {
			this.raisonSocial = raisonSocial;
		}
		
		public EntrepriseDTO() {
			super();
		}
		
		

		public EntrepriseDTO(int id,String name, String raisonSocial) {
			super();
			this.name = name;
			this.raisonSocial = raisonSocial;
			this.id = id;
		}

		public EntrepriseDTO(String name, String raisonSocial) {
			super();
			this.name = name;
			this.raisonSocial = raisonSocial;
		}

		public EntrepriseDTO(int id) {
			super();
			this.id = id;
		}	
		
}

