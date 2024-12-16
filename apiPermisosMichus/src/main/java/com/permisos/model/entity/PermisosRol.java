package com.permisos.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PERMISOS_ROL")
@IdClass(PermisosRol.PermisosRolId.class)
public class PermisosRol {

	 @Id
	    @Column(name = "ID_ROL", length = 5, nullable = false)
	    private String idRol;

	    @Id
	    @Column(name = "ID_SUBMENU", nullable = false)
	    private Integer idSubmenu;

	    @Column(name = "FECHA_CREACION", nullable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "FECHA_MODIFICACION", nullable = false)
	    private LocalDateTime fechaModificacion;

	    @PrePersist
	    public void prePersist() {
	        this.fechaCreacion = LocalDateTime.now();
	        this.fechaModificacion = LocalDateTime.now();
	    }

	    @PreUpdate
	    public void preUpdate() {
	        this.fechaModificacion = LocalDateTime.now();
	    }

	    // Getters y setters
	    public String getIdRol() {
	        return idRol;
	    }

	    public void setIdRol(String idRol) {
	        this.idRol = idRol;
	    }

	    public Integer getIdSubmenu() {
	        return idSubmenu;
	    }

	    public void setIdSubmenu(Integer idSubmenu) {
	        this.idSubmenu = idSubmenu;
	    }

	    public LocalDateTime getFechaCreacion() {
	        return fechaCreacion;
	    }

	    public void setFechaCreacion(LocalDateTime fechaCreacion) {
	        this.fechaCreacion = fechaCreacion;
	    }

	    public LocalDateTime getFechaModificacion() {
	        return fechaModificacion;
	    }

	    public void setFechaModificacion(LocalDateTime fechaModificacion) {
	        this.fechaModificacion = fechaModificacion;
	    }

	    // Clave primaria compuesta
	    public static class PermisosRolId implements Serializable {
	        private String idRol;
	        private Integer idSubmenu;

	        public PermisosRolId() {}

	        public PermisosRolId(String idRol, Integer idSubmenu) {
	            this.idRol = idRol;
	            this.idSubmenu = idSubmenu;
	        }

	        // Getters y setters
	        public String getIdRol() {
	            return idRol;
	        }

	        public void setIdRol(String idRol) {
	            this.idRol = idRol;
	        }

	        public Integer getIdSubmenu() {
	            return idSubmenu;
	        }

	        public void setIdSubmenu(Integer idSubmenu) {
	            this.idSubmenu = idSubmenu;
	        }

	        @Override
	        public boolean equals(Object o) {
	            if (this == o) return true;
	            if (o == null || getClass() != o.getClass()) return false;
	            PermisosRolId that = (PermisosRolId) o;
	            return Objects.equals(idRol, that.idRol) && Objects.equals(idSubmenu, that.idSubmenu);
	        }

	        @Override
	        public int hashCode() {
	            return Objects.hash(idRol, idSubmenu);
	        }
	    }
	}