package com.permisos.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.Rol;
import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.repository.IRolRepository;
import com.permisos.model.repository.IUsuariosSistemaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuariosSistemaService {

	private IUsuariosSistemaRepository usuariosSistemaRepository;
	private IRolRepository rolRepository;
	
	public String crearUsuario(String idUsuario, String usuario, String email, String contrasenia, String idRol) {
		Rol rol = rolRepository.findById(idRol).orElseThrow(() ->
				new IllegalArgumentException("Rol no encontrado"));
				
			UsuariosSistema nuevoUsuario = new UsuariosSistema();
		
			nuevoUsuario.setIdUsuario(idUsuario);
			nuevoUsuario.setUsuario(usuario);
			nuevoUsuario.setEmail(email);
			nuevoUsuario.setContrasenia(contrasenia);
			nuevoUsuario.setIdRol(rol);
			nuevoUsuario.setFechaCreacion(LocalDateTime.now());
			nuevoUsuario.setEstado((byte) 1);
			
			usuariosSistemaRepository.save(nuevoUsuario);
			
			return "Usuario creado correctamente";
	}
}
