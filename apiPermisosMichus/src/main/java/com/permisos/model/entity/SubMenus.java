package com.permisos.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SUBMENUS")
@Data
public class SubMenus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SUBMENU")
	private Long idSubMenus;
	
	@ManyToOne
	@JoinColumn(name = "ID_MENU", nullable = false)
	private Menu idMenu;
	
	@Column(name = "NOMBRE_SUBMENU", length = 50, nullable = false)
	private String nombreSubMenu;
	
	@Column(name = "ENLACE_SUBMENU", length = 100)
	private String enlaceSubMenu;
	
	@Column(name = "ORDEN_SUBMENU")
	private Integer ordenSubMenu;
	
	@Column(name = "ESTADO_SUBMENU", nullable = false)
	private Integer estadoSubMenu;
	
	@Column(name = "FECHA_CREACION")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private LocalDateTime fechaModificacion;
}
