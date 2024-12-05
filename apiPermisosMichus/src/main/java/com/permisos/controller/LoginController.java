package com.permisos.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.service.LoginService;

@RestController
@RequestMapping("api/login")
public class LoginController {

	private final LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping
    public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String contrasenia) {
       Map<String, Object> result = loginService.login(email, contrasenia);

       //VALIDAR LAS CREDENCIALES
        if (result.containsKey("p_mensaje") && result.get("p_mensaje").equals("Correo o Contraseña Incorrecta")) {
            return ResponseEntity.badRequest().body(result);
        }

        //VALIDAR EL ROL
        if (result.containsKey("p_rol")&& !result.get("p_rol").equals("R01")) 
        {
			result.put("p_mensaje", "Acceso no permitido.");
			return ResponseEntity.status(403).body(result);
		}
        return ResponseEntity.ok(result);
    }
}
