package tn.esprit.spring.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.EmployeDTO;

import java.util.stream.Collectors;

@Component
public class EmployeConverter {
	
	   //Transformer employe DTO en Employe
       public Employe empTodo(EmployeDTO employe) {
    	   ModelMapper mapper =new ModelMapper();
    	   return mapper.map(employe, Employe.class);
       }
       
       //Transformer employe en employe DTO
       public EmployeDTO entityToDTO(Employe emp) {
   		ModelMapper mapper =new ModelMapper();
   		return mapper.map(emp, EmployeDTO.class);

   		
   	}
       //Retourner la liste des employe DTO
       public  List<EmployeDTO> emplistToDTO(List<Employe> emp) {
   		return	emp.stream().map(this::entityToDTO).collect(Collectors.toList());
   		
   	}
	
}
