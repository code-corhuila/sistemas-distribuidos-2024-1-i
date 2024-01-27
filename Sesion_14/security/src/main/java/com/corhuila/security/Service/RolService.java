package com.corhuila.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.security.Entity.Rol;
import com.corhuila.security.IRepository.IBaseRepository;
import com.corhuila.security.IRepository.IRolRepository;
import com.corhuila.security.IService.IRolService;

@Service
public class RolService extends BaseService<Rol> implements IRolService{

	@Override
	protected IBaseRepository<Rol, Long> getRepository() {
		return repository;
	}

	@Autowired
	private IRolRepository repository;

}