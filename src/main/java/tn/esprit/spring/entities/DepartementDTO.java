package tn.esprit.spring.entities;

import lombok.Data;


@Data
public class DepartementDTO {
   private int id;
   private String name;

	  public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

public DepartementDTO(String name) {
	super();
	this.name = name;
}
public DepartementDTO() {
	super();
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}


   }
