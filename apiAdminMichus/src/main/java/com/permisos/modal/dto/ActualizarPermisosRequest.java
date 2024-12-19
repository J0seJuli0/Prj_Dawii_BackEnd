package com.permisos.modal.dto;

public record ActualizarPermisosRequest(
	    String idRol,
	    Integer idSubmenuActual,
	    Integer idSubmenuNuevo
	) {}
