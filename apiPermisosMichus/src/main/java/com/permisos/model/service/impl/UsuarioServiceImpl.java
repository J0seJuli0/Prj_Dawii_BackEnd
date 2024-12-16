package com.permisos.model.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.permisos.model.dto.LoginInputDTO;
import com.permisos.model.dto.LoginOutputDTO;
import com.permisos.model.entity.Rol;
import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.repository.IUsuariosSistemaRepository;
import com.permisos.model.service.ILoginService;
import com.permisos.security.JwtUtil;
import com.permisos.util.BCryptUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements ILoginService {

    private AuthenticationManager authenticationManager;
    IUsuariosSistemaRepository usuariosSistemaRepository;
    private JwtUtil jwtUtil;
    private BCryptUtil bcryptUtil;

    @Override
    public LoginOutputDTO login(LoginInputDTO inputDTO) {
    	UsuariosSistema usuario = usuariosSistemaRepository.findByEmail(inputDTO.email()).orElse(null);
		if(usuario!=null) {
			if(bcryptUtil.validarPassword(inputDTO.Clave(), usuario.getContrasenia())){
				Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(inputDTO.email(), inputDTO.Clave())
						);
				Rol rol = usuario.getRol();
				if(authentication.isAuthenticated()) {
					String token = jwtUtil.generateToken(usuario.getEmail(), rol.getRol());
					return new LoginOutputDTO(Boolean.TRUE, "Operación realizada correctamente", token);
				}else {
					return new LoginOutputDTO(Boolean.FALSE, "Usuario y/o contraseña invalidos", null);
				}
			}else {
				return new LoginOutputDTO(Boolean.FALSE, "Usuario y/o contraseña invalidos", null);
			}
		}else {
			return new LoginOutputDTO(Boolean.FALSE, "Usuario y/o contraseña invalidos", null);
		}
	}
}
