package com.permisos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.PermisosRol;
import com.permisos.model.repository.IPermisoRolRepository;
import com.permisos.model.request.ActualizarPermisosRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/permisosRol")
@AllArgsConstructor
public class PermisosRolController {

	private IPermisoRolRepository permisoRolRepository;
	
	
	@GetMapping("/listar")
	public List<PermisosRol> listar(){
		return permisoRolRepository.findAll();
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarPermiso(@RequestBody ActualizarPermisosRequest request) {
	    String idRol = request.getIdRol();
	    Integer idSubmenuActual = request.getIdSubmenuActual();
	    Integer idSubmenuNuevo = request.getIdSubmenuNuevo();

	    // Verificar que exista el registro con la combinación actual
	    PermisosRol.PermisosRolId permisoId = new PermisosRol.PermisosRolId(idRol, idSubmenuActual);
	    if (!permisoRolRepository.existsById(permisoId)) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("El permiso con idRol y idSubmenu actual no fue encontrado.");
	    }

	    // Actualizar el idSubmenu
	    int rowsAffected = permisoRolRepository.updateSubmenu(idRol, idSubmenuActual, idSubmenuNuevo);
	    if (rowsAffected > 0) {
	        return ResponseEntity.ok("El permiso fue actualizado exitosamente.");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Ocurrió un error al actualizar el permiso.");
	    }
	}



}
