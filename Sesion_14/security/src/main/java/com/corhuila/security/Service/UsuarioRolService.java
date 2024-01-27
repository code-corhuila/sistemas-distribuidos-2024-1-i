package com.corhuila.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.security.Entity.UsuarioRol;
import com.corhuila.security.IRepository.IBaseRepository;
import com.corhuila.security.IRepository.IUsuarioRolRepository;
import com.corhuila.security.IService.IUsuarioRolService;

@Service
public class UsuarioRolService extends BaseService<UsuarioRol> implements IUsuarioRolService{

	@Override
	protected IBaseRepository<UsuarioRol, Long> getRepository() {
		return repository;
	}

	@Autowired
	private IUsuarioRolRepository repository;

}
