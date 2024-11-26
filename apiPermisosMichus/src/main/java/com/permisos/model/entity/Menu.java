package com.permisos.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MENUS")
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MENU")
	private Long idMenu;
	
	@Column(name = "NOMBRE_MENU", length = 50, nullable = false)
	private String nombreMenu;
	
	@Column(name = "ORDEN_MENU", nullable = false)
	private Integer ordenMenu;
	
	@Column(name = "ESTADO_MENU", nullable = false)
	private Boolean estadoMenu;
	
	@Column(name = "FECHA_CREACION", nullable = false)
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION", nullable = false)
	private LocalDateTime fechaModificacion;
}
