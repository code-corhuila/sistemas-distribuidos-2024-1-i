package com.corhuila.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.security.Entity.Rol;
import com.corhuila.security.IService.IRolService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/Rol")
public class RolController extends BaseController<Rol,IRolService> {
	 public RolController(IRolService service) {
	        super(service, "Rol");
	 }
}
