package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.dto.DetallePermisoDTO;
import com.permisos.model.service.PermisoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/permisosRol")
@AllArgsConstructor
public class PermisoController {

    private PermisoService permisoService;

    @GetMapping("/detalles/{idRol}")
    public List<DetallePermisoDTO> obtenerDetallesPorRol(@PathVariable String idRol) {
        return permisoService.listarDetallesPorRol(idRol);
    }
}