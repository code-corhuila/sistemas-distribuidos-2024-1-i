package com.corhuila.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.security.Entity.Persona;
import com.corhuila.security.IRepository.IBaseRepository;
import com.corhuila.security.IRepository.IPersonaRepository;
import com.corhuila.security.IService.IPersonaService;

@Service
public class PersonaService extends BaseService<Persona> implements IPersonaService{

	@Override
	protected IBaseRepository<Persona, Long> getRepository() {
		return repository;
	}

	@Autowired
	private IPersonaRepository repository;

}
