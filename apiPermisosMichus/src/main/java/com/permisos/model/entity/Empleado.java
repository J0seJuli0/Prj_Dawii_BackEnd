package com.permisos.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLEADO")
@Data
public class Empleado {

	@Id
	@Column(name = "ID_EMPLEADO")
	private String idEmpleado;
	
	@Column(name = "NOMBRES", length = 50, nullable = false)
	private String nombres;
	
	@Column(name = "APELLIDOS", length = 50)
	private String apellidos;
	
	@Column(name = "FECHA_NACIMIENTO", nullable = false)
	private LocalDateTime fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "ID_DOC", nullable = false)
	private TipoDocumento idDocumento;
	
	@Column(name = "DOC_IDENT", length = 15)
	private String docIdentidad;
	
	@Column(name = "SALARIO", precision = 10, scale = 2)
	private BigDecimal salario;
	
	@Column(name = "FECHA_INGRESO", nullable = false)
	private LocalDateTime fechaIngreso;
	
	@Column(name = "ESTADO")
	private Byte estado;
	
	@Column(name = "FECHA_REGISTRO")
	private LocalDateTime fechaRegistro;
	
	@Column(name = "FECHA_ACTUALIZACION")
	private LocalDateTime fechaActualizacion;
}
