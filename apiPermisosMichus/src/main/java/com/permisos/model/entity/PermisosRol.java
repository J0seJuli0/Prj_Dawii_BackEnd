package com.permisos.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERMISOS_ROL")
@Data
public class PermisosRol {

	   
	@EmbeddedId
	private PermisosRolId id;

	@Column(name = "FECHA_CREACION")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private LocalDateTime fechaModificacion;
	
	 // Getters y Setters para idRol y idSubMenu
    public String getIdRol() {
        return id.getIdRol();
    }

    public void setIdRol(String idRol) {
        id.setIdRol(idRol);
    }

    public Long getIdSubMenu() {
        return id.getIdSubmenu();
    }

    public void setIdSubMenu(Long idSubMenu) {
        id.setIdSubmenu(idSubMenu);
    }
}
