package com.permisos.modal.dto;

public record LoginOutputDTO(
		Boolean success,
		String respuesta,
		String token
		) {}
