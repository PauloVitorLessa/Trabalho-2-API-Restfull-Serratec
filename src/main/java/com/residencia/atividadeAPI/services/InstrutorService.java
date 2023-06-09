package com.residencia.atividadeAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.atividadeAPI.entities.Instrutor;
import com.residencia.atividadeAPI.repositories.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	InstrutorRepository instrutorRepository;
	
	@Autowired
	EmailService emailService;
	
	public List <Instrutor>getAllInstrutores() {
		
		return instrutorRepository.findAll();
	}
	
	public Instrutor getInstrutorById(Long id) {
		
		return instrutorRepository.findById(id).orElse(null);	
	}
	
	public Instrutor saveInstrutor(Instrutor instrutor) {	
			
			Instrutor  instrutorResponse = instrutorRepository.save(instrutor);
			emailService.enviarEmail("paulo.vitor.lessa@gmail.com", "instrutor cadastrado", instrutorResponse.toString());
			return instrutorResponse;		
	}
	
	public Instrutor updateInstrutor(Instrutor instrutor) {
		
		return instrutorRepository.save(instrutor);
	}	
	
	public Boolean deleteInstrutor(Long id) {
		
		if(instrutorRepository.findById(id).orElse(null) != null) {
			instrutorRepository.deleteById(id);
			if(instrutorRepository.findById(id).orElse(null) == null)
				return true;
			else
				return false;
		}		
		else
			return false;
	}

}
