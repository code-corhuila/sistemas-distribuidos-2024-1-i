package com.corhuila.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.security.Entity.Usuario;
import com.corhuila.security.IRepository.IBaseRepository;
import com.corhuila.security.IRepository.IUsuarioRepository;
import com.corhuila.security.IService.IUsuarioService;

@Service
public class UsuarioService extends BaseService<Usuario> implements IUsuarioService{

	@Override
	protected IBaseRepository<Usuario, Long> getRepository() {
		return repository;
	}

	@Autowired
	private IUsuarioRepository repository;

}
