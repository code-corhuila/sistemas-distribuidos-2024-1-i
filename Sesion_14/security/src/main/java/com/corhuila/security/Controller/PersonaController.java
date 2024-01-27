package com.corhuila.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.security.Entity.Persona;
import com.corhuila.security.IService.IPersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/Persona")
public class PersonaController extends BaseController<Persona,IPersonaService> {
	 public PersonaController(IPersonaService service) {
	        super(service, "Persona");
	 }
}
