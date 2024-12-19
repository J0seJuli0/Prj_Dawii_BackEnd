package com.permisos.modal.dto;

import java.time.LocalDateTime;

public record PermisosRolDTO(
		String idRol,
		Long idSubmenu,
	    LocalDateTime fechaCreacion,
	    LocalDateTime fechaModificacion
	    
	    
	) {
	}
