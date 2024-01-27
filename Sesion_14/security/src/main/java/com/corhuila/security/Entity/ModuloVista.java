package com.corhuila.security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "modulo_vista")
public class ModuloVista extends Auditoria{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "modulo_id", nullable = false, unique = true)	
	private Modulo moduloId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "vista_id", nullable = false, unique = true)	
	private Vista vistaId;

	public Modulo getModuloId() {
		return moduloId;
	}

	public void setModuloId(Modulo moduloId) {
		this.moduloId = moduloId;
	}

	public Vista getVistaId() {
		return vistaId;
	}

	public void setVistaId(Vista vistaId) {
		this.vistaId = vistaId;
	}
}


