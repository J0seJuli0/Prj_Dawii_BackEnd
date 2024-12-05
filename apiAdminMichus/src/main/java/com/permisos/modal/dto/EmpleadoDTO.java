package com.permisos.modal.dto;

import java.util.Date;

public record EmpleadoDTO(
		String idEmpleado,
		String nombres,
		String apellidos,
		Date fechaNacimiento,
		TipoDocumentoDTO idDocumento,
		String docIdentidad,
		Double salario,
		Date fechaIngreso,
		Byte estado,
		Date fechaRegistro,
		Date fechaActualizacion
		
		) {

}
