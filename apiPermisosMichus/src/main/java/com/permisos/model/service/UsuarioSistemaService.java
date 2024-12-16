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
        // Buscar el usuario
        UsuariosSistema usuario = usuariosSistemaRepository.findByIdUsuario(idUsuario);

        if (usuario != null) {
            // Buscar el rol
            Rol rolNuevo = rolRepository.findById(idRol).orElse(null);

            if (rolNuevo != null) {
                // Actualizar el rol
                usuario.setRol(rolNuevo);
                // Establecer la fecha de modificación
                usuario.setFechaModificacion(LocalDateTime.now());

                // Guardar los cambios
                return usuariosSistemaRepository.save(usuario);
            }
        }

        return null; // Si el usuario o el rol no existen
    }
}
