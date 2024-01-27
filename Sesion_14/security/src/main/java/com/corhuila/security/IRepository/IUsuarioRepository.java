package com.corhuila.security.IRepository;

import org.springframework.stereotype.Repository;

import com.corhuila.security.Entity.Usuario;

@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Long>{

}
