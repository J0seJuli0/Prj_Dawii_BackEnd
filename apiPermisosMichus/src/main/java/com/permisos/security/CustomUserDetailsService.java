package com.permisos.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.permisos.model.entity.Rol;
import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.repository.IUsuariosSistemaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService{
	private IUsuariosSistemaRepository usuariosSistemaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuariosSistema usuarios = usuariosSistemaRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));
		Rol rol = usuarios.getRol();
		
		return User
				.withUsername(usuarios.getEmail())
				.password(usuarios.getContrasenia())
				.roles(rol.getRol())
				.build();
	}

}
