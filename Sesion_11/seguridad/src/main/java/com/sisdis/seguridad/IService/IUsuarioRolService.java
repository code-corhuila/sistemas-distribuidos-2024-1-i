package com.sisdis.seguridad.IService;

import java.util.List;
import java.util.Optional;

import com.sisdis.seguridad.Entity.UsuarioRol;

public interface IUsuarioRolService {

	//Obtener todo
	public List<UsuarioRol> all();
	
	//Obtener por ID
	public Optional<UsuarioRol> findById(Long id);
 	
	//Crear
	public UsuarioRol save(UsuarioRol usuarioRol);
	
	//Modificar
	public void update(UsuarioRol usuarioRol, Long id);
	
	//Eliminar Físico
	public void deletePhysical(Long id);
}
