package com.permisos.modal.dto;

import java.time.LocalDateTime;

public record PermisosRolDTO(
	    IdDTO id,
	    LocalDateTime fechaCreacion,
	    LocalDateTime fechaModificacion,
	    String idRol,
	    Long idSubMenu
	    
	) {

	    public record IdDTO(
	        String idRol,
	        Long idSubmenu
	    ) {}
	    
	}
