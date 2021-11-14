package tn.esprit.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.EntrepriseDTO;

@Component
public class EntrepriseConverter {
	//Transformer entreprise DTO en entreprise
    public Entreprise entrepriseTodo(EntrepriseDTO entreprise) {
 	   ModelMapper mapper =new ModelMapper();
 	 return mapper.map(entreprise, Entreprise.class);

    }
    
    //Transformer entreprise en entreprise DTO
    public EntrepriseDTO entityToDTO(Entreprise entreprise) {
		ModelMapper mapper =new ModelMapper();
		return mapper.map(entreprise, EntrepriseDTO.class);
		
	}
    //Retourner la liste des departement DTO
    public  List<EntrepriseDTO> entrepriselistToDTO(List<Entreprise> entreprise) {
		return	entreprise.stream().map(this::entityToDTO).collect(Collectors.toList());
		
	}
}
