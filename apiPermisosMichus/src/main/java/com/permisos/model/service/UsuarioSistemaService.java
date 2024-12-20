package com.permisos.model.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.Rol;
import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.repository.IRolRepository;
import com.permisos.model.repository.IUsuariosSistemaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioSistemaService {

	private IUsuariosSistemaRepository usuariosSistemaRepository;
	private IRolRepository rolRepository;
	 
	@Transactional
    public UsuariosSistema actualizarRol(String idUsuario, String idRol) { 
        UsuariosSistema usuario = usuariosSistemaRepository.findByIdUsuario(idUsuario);

        if (usuario != null) { 
            Rol rolNuevo = rolRepository.findById(idRol).orElse(null);

            if (rolNuevo != null) { 
                usuario.setRol(rolNuevo); 
                usuario.setFechaModificacion(LocalDateTime.now());
 
                return usuariosSistemaRepository.save(usuario);
            }
        }

        return null;  
    }
}
