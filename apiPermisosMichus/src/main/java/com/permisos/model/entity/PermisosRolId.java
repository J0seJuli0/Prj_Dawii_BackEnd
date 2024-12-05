package com.permisos.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PermisosRolId implements Serializable {

    @Column(name = "ID_ROL") // Mapea el nombre de la columna en la BD
    private String idRol;

    @Column(name = "ID_SUBMENU") // Mapea el nombre de la columna en la BD
    private Long idSubmenu;

    // Constructor vacío para JPA
    public PermisosRolId() {}

    // Constructor con parámetros
    public PermisosRolId(String idRol, Long idSubmenu) {
        this.idRol = idRol;
        this.idSubmenu = idSubmenu;
    }

    // Getters y Setters
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public Long getIdSubmenu() {
        return idSubmenu;
    }

    public void setIdSubmenu(Long idSubmenu) {
        this.idSubmenu = idSubmenu;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisosRolId that = (PermisosRolId) o;
        return Objects.equals(idRol, that.idRol) &&
               Objects.equals(idSubmenu, that.idSubmenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, idSubmenu);
    }
}
