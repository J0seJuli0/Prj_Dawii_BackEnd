package com.permisos.modal.dto;

import java.util.Date;

public record MenuDTO(
		Long idMenu,
		String nombreMenu,
		Integer ordenMenu,
		Boolean estadoMenu,
		Date fechaCreacion,
		Date fechaModificacion
		
		) {

}
