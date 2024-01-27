package com.corhuila.security.IRepository;

import org.springframework.stereotype.Repository;

import com.corhuila.security.Entity.Persona;

@Repository
public interface IPersonaRepository extends IBaseRepository<Persona, Long>{

}
