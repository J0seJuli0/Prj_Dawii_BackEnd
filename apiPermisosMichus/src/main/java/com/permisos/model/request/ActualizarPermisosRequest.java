package com.permisos.model.request;

public class ActualizarPermisosRequest {
    private String idRol;
    private Integer idSubmenuActual;
    private Integer idSubmenuNuevo;

    // Getters y Setters
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public Integer getIdSubmenuActual() {
        return idSubmenuActual;
    }

    public void setIdSubmenuActual(Integer idSubmenuActual) {
        this.idSubmenuActual = idSubmenuActual;
    }

    public Integer getIdSubmenuNuevo() {
        return idSubmenuNuevo;
    }

    public void setIdSubmenuNuevo(Integer idSubmenuNuevo) {
        this.idSubmenuNuevo = idSubmenuNuevo;
    }
}
