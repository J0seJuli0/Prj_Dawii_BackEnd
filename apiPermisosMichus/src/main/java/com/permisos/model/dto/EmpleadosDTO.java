package com.permisos.model.dto;

public record EmpleadosDTO(
		String codigo,
		String nombres,
	    String apellidos,
	    String documento,
	    String numDoc,
	    String fechaIngreso,
	    String estado,
	    String rol
	    ) {

}
