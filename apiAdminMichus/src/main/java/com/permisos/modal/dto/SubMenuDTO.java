package com.permisos.modal.dto;

import java.util.Date;

public record SubMenuDTO(
		Long idSubMenus,
		MenuDTO idMenu,
		String nombreSubMenu,
		String enlaceSubMenu,
		Integer ordenSubMenu,
		Boolean estadoSubMenu,
		Date fechaCreacion,
		Date fechaModificacion
		) {

}
