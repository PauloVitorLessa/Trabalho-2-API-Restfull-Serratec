package com.residencia.atividadeAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.atividadeAPI.entities.Turma;
import com.residencia.atividadeAPI.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	EmailService emailService;
	
	public List <Turma>getAllTurmaes() {
		
		return turmaRepository.findAll();
	}
	
	public Turma getTurmaById(Long id) {
		
		return turmaRepository.findById(id).orElse(null);	
	}
	
	public Turma saveTurma(Turma turma) {
		
		Turma turmaResponse = turmaRepository.save(turma);
		emailService.enviarEmail("paulo.vitor.lessa@gmail.com", "turma cadastrado", turmaResponse.toString());
		return turmaResponse;		
	}
	
	public Turma updateTurma(Turma turma) {
		
		return turmaRepository.save(turma);
	}	
	
	public Boolean deleteTurma(Long id) {
		
		if(turmaRepository.findById(id).orElse(null) != null) {
			turmaRepository.deleteById(id);
			if(turmaRepository.findById(id).orElse(null) == null)
				return true;
			else
				return false;
		}		
		else
			return false;
	}

}
