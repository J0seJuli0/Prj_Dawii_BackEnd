package com.permisos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ROLES")
@Data
public class Rol {

	@Id
	@Column(name = "ID_ROL", length = 5)
	private String idRol;
	
	@Column(name = "ROL", length = 50, nullable = false)
	private String rol;
	
	@Column(name = "TIPO_USUARIO", nullable = false)
	private Byte tipoUsuario;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
}
