package com.permisos.modal.dto;

import java.time.LocalDateTime;

public record SubMenuDTO(
		Long idSubMenus,
	    MenuDTO idMenu,
	    String nombreSubMenu,
	    String enlaceSubMenu,
	    Integer ordenSubMenu,
	    Integer estadoSubMenu,
	    LocalDateTime fechaCreacion,
	    LocalDateTime fechaModificacion
	) {
	}
