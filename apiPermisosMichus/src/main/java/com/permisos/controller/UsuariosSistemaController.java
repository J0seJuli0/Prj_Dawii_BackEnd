package com.permisos.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.repository.IUsuariosSistemaRepository;
import com.permisos.service.UsuariosSistemaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuariosSistema")
@AllArgsConstructor
public class UsuariosSistemaController {

	private IUsuariosSistemaRepository usuariosSistemaRepository;
	private UsuariosSistemaService usuariosSistemaService;
	
	@GetMapping("/listar")
	public List<UsuariosSistema> lista(){
		return usuariosSistemaRepository.findAll();
	}
	
	@PostMapping("/crear")
	public String crearUsuario(@RequestBody Map<String, String> payload) {
			String idUsuario = payload.get("idUsuario");
		    String usuario = payload.get("usuario");
		    String email = payload.get("email");
		    String contrasenia = payload.get("contrasenia");
		    String idRol = payload.get("idRol");
		    
		    //ENCRIPTAMOS LA CONTRASENIA ANTES DE ENVIAR
		    String contraseniaEncriptada = encriptarContrasenia(contrasenia);
		return usuariosSistemaService.crearUsuario(idUsuario, usuario, email, contraseniaEncriptada, idRol);
	}

	private String encriptarContrasenia(String contrasenia) {
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
		
			byte[] hash = digest.digest(contrasenia.getBytes());
			StringBuilder hexString = new StringBuilder();
			
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)hexString.append('0');
				hexString.append(hex);
			}
			
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error al encriptar la contraseña.");
		}
	}
	
	
	
	
}



