package com.corhuila.security.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.security.Entity.Auditoria;

@Repository
public interface IBaseRepository <T extends Auditoria, ID> extends JpaRepository<T, ID> {
  
}