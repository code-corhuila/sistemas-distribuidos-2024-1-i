package com.corhuila.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.security.Entity.Usuario;
import com.corhuila.security.IService.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/Usuario")
public class UsuarioController extends BaseController<Usuario,IUsuarioService> {
	 public UsuarioController(IUsuarioService service) {
	        super(service, "Usuario");
	 }
}

