package com.permisos.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USUARIOS_SISTEMAS")
@Data
public class UsuariosSistema {

	@Id
	@Column(name = "ID_USUARIO", length = 5, nullable = false)
	private String idUsuario;
	
	@Column(name = "USUARIO", length = 50, nullable = false)
	private String usuario;
	
	@Column(name = "EMAIL", length = 100, nullable = false)
	private String email;
	
	@Column(name = "CONTRASENIA", length = 100, nullable = false)
	private String contrasenia;
	
	@ManyToOne
	@JoinColumn(name = "ID_ROL")
	private Rol idRol;
	
	@Column(name = "FECHA_CREACION")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private LocalDateTime fechaModificacion;
	
	@Column(name = "ESTADO")
	private Byte estado;
}
