package com.corhuila.security.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol extends Auditoria{

	@Column(name = "codigo", length = 20, nullable = false)
	private String codigo;
	
	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "descripcion", length = 50, nullable = false)
	private String descripcion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}


