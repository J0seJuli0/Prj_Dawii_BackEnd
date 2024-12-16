package com.permisos.model.dto;

public record LoginOutputDTO(
		Boolean success,
		String respuesta,
		String token
		) {

}
