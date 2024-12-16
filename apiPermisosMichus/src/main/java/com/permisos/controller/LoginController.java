package com.permisos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.dto.LoginInputDTO;
import com.permisos.model.dto.LoginOutputDTO;
import com.permisos.model.service.ILoginService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/usuario")
public class LoginController {

	private ILoginService usuariosService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginOutputDTO> login(@RequestBody LoginInputDTO inputDTO){
		return ResponseEntity.ok(usuariosService.login(inputDTO));
	}
	
}
