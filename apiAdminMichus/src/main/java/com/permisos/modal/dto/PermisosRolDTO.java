package com.permisos.modal.dto;

import java.time.LocalDateTime;

public record PermisosRolDTO(
	    IdDTO id,
	    LocalDateTime  fechaCreacion,
	    LocalDateTime  fechaModificacion
	) {
	    public record IdDTO(
	        String idRol,
	        int idSubmenu
	    ) {}
	}
