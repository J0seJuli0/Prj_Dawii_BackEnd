package com.permisos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.service.UsuarioSistemaService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosSistemaController {

    @Autowired
    private UsuarioSistemaService usuariosSistemaService;

    @PutMapping("/actualizar-rol")
    public ResponseEntity<?> actualizarRol(@RequestBody Map<String, String> request) {
        String idUsuario = request.get("idUsuario");
        String idRol = request.get("idRol");

        UsuariosSistema usuarioActualizado = usuariosSistemaService.actualizarRol(idUsuario, idRol);

        if (usuarioActualizado != null) {
            return ResponseEntity.ok("Usuario Actualizado Correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o Rol no encontrado");
        }
    }

}
