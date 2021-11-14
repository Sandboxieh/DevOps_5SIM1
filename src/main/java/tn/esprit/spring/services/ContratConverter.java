package tn.esprit.spring.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.ContratDTO;

import java.util.stream.Collectors;

@Component
public class ContratConverter {
	
	   //Transformer Contrat Dto en contrat
       public Contrat contdto(ContratDTO nvcontrat) {
    	   ModelMapper mapper =new ModelMapper();
    	 return mapper.map(nvcontrat, Contrat.class);
   		
       }
       
       //Transformer contrat en contrat DTO
       public ContratDTO entityToDTO(Contrat cont) {
   		ModelMapper mapper =new ModelMapper();
   		return mapper.map(cont, ContratDTO.class);
   		
   	}
       //Retourner la liste des Contrat DTO
       public  List<ContratDTO> contlistToDTO(List<Contrat> contrat) {
   		return	contrat.stream().map(this::entityToDTO).collect(Collectors.toList());
   		
   	}
	
}
