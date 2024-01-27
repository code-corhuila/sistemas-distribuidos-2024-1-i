package com.corhuila.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.security.Entity.UsuarioRol;
import com.corhuila.security.IService.IUsuarioRolService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/UsuarioRol")
public class UsuarioRolController extends BaseController<UsuarioRol,IUsuarioRolService> {
	 public UsuarioRolController(IUsuarioRolService service) {
	        super(service, "UsuarioRol");
	 }
}
