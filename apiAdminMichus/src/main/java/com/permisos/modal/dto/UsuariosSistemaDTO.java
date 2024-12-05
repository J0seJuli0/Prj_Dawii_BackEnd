package com.permisos.modal.dto;

import java.util.Date;

public record UsuariosSistemaDTO(
		String idUsuario,
		String usuario,
		String email,
		String contrasenia,
		RolDTO idRol,
		Date fechaCreacion,
		Date fechaModificacion,
		Byte estado
		) {

}
