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
	public List<Persona> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Persona> finById(Long id) {
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
	public void detelePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deteleLogical(Long id) {
		// TODO Auto-generated method stub		
	}	
}
