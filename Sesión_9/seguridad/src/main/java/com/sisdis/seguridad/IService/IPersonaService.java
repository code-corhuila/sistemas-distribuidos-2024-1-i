package com.sisdis.seguridad.IService;

import java.util.List;
import java.util.Optional;

import com.sisdis.seguridad.Entity.Persona;

public interface IPersonaService {

	//Obtener todo
	public List<Persona> findAll();
	
	//Obtener por ID
	public Optional<Persona> finById(Long id);
 	
	//Crear
	public Persona save(Persona persona);
	
	//Modificar
	public void update(Persona persona, Long id);
	
	//Eliminar Físico
	public void detelePhysical(Long id);
	
	//Eliminar lógico
	public void deteleLogical(Long id);
}
