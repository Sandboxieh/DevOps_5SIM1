package tn.esprit.spring.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.DepartementDTO;

import java.util.stream.Collectors;

@Component
public class DepartementConverter {
	
	   //Transformer departement DTO en Departement
       public Departement depTodo(DepartementDTO departement) {
    	   ModelMapper mapper =new ModelMapper();
    	   return mapper.map(departement, Departement.class);
       }
       
       //Transformer departement en deprtement DTO
       public DepartementDTO entityToDTO(Departement dep) {
   		ModelMapper mapper =new ModelMapper();
   		return mapper.map(dep, DepartementDTO.class);
   		
   	}
       //Retourner la liste des departement DTO
       public  List<DepartementDTO> deplistToDTO(List<Departement> departement) {
   		return	departement.stream().map(this::entityToDTO).collect(Collectors.toList());
   		
   	}
	
}
