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
@Table(name = "PERMISOS_ROL")
@Data
public class PermisosRol {

	@Id
	@Column(name = "ID_ROL", length = 5)
	private String idRol;
	
	@ManyToOne
	@JoinColumn(name = "ID_SUBMENU", nullable = false)
	private SubMenus idSubMenu;
	
	@Column(name = "FECHA_CREACION")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private LocalDateTime fechaModificacion;
}
