package com.permisos.modal.dto;

import java.util.Date;

public record DetallePermisoDTO(
		String idRol,
	    Integer idSubmenu,
	    String nombreSubmenu,
	    String enlaceSubmenu,
	    Integer ordenSubmenu,
	    Integer estadoSubmenu,
	    Date fechaCreacionSubmenu,
	    Date fechaModificacionSubmenu
	) {}
