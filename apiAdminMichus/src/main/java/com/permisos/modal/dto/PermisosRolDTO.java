package com.permisos.modal.dto;

import java.util.Date;

public record PermisosRolDTO(
		String idRol,
		SubMenuDTO idSubMenu,
		Date fechaCreacion,
		Date fechaModificacion
		) {

}
