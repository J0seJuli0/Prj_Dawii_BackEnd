package com.permisos.model.dto;

import java.util.Date;

public class DetallePermisoDTO {

    private String idRol;
    private Integer idSubmenu;
    private String nombreSubmenu;
    private String enlaceSubmenu;
    private Integer ordenSubmenu;
    private Integer estadoSubmenu;
    private Date fechaCreacionSubmenu;
    private Date fechaModificacionSubmenu;

    public DetallePermisoDTO(String idRol, Integer idSubmenu, String nombreSubmenu,
                             String enlaceSubmenu, Integer ordenSubmenu, Integer estadoSubmenu,
                             Date fechaCreacionSubmenu, Date fechaModificacionSubmenu) {
        this.idRol = idRol;
        this.idSubmenu = idSubmenu;
        this.nombreSubmenu = nombreSubmenu;
        this.enlaceSubmenu = enlaceSubmenu;
        this.ordenSubmenu = ordenSubmenu;
        this.estadoSubmenu = estadoSubmenu;
        this.fechaCreacionSubmenu = fechaCreacionSubmenu;
        this.fechaModificacionSubmenu = fechaModificacionSubmenu;
    }
 
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

    public String getNombreSubmenu() {
        return nombreSubmenu;
    }

    public void setNombreSubmenu(String nombreSubmenu) {
        this.nombreSubmenu = nombreSubmenu;
    }

    public String getEnlaceSubmenu() {
        return enlaceSubmenu;
    }

    public void setEnlaceSubmenu(String enlaceSubmenu) {
        this.enlaceSubmenu = enlaceSubmenu;
    }

    public Integer getOrdenSubmenu() {
        return ordenSubmenu;
    }

    public void setOrdenSubmenu(Integer ordenSubmenu) {
        this.ordenSubmenu = ordenSubmenu;
    }

    public Integer getEstadoSubmenu() {
        return estadoSubmenu;
    }

    public void setEstadoSubmenu(Integer estadoSubmenu) {
        this.estadoSubmenu = estadoSubmenu;
    }

    public Date getFechaCreacionSubmenu() {
        return fechaCreacionSubmenu;
    }

    public void setFechaCreacionSubmenu(Date fechaCreacionSubmenu) {
        this.fechaCreacionSubmenu = fechaCreacionSubmenu;
    }

    public Date getFechaModificacionSubmenu() {
        return fechaModificacionSubmenu;
    }

    public void setFechaModificacionSubmenu(Date fechaModificacionSubmenu) {
        this.fechaModificacionSubmenu = fechaModificacionSubmenu;
    }
}
