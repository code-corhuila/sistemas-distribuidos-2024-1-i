package com.sisdis.seguridad.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisdis.seguridad.Entity.Persona;
import com.sisdis.seguridad.IRepository.IPersonaRepository;
import com.sisdis.seguridad.IService.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public List<Persona> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Persona save(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public void update(Persona persona, Long id) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		// TODO Auto-generated method stub		
	}	
}
