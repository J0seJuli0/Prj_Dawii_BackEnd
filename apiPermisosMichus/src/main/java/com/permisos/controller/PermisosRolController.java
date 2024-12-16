package com.permisos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.PermisosRol;
import com.permisos.model.entity.PermisosRolId;
import com.permisos.model.repository.IPermisoRolRepository;
import com.permisos.model.service.IPermisosRolService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/permisosRol")
@AllArgsConstructor
public class PermisosRolController {

	private IPermisoRolRepository permisoRolRepository;
	
	private IPermisosRolService permisosRolService;
	
	@GetMapping("/listar")
	public List<PermisosRol> listar(){
		return permisoRolRepository.findAll();
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<String> registrarPermisoRol(@RequestBody PermisosRol permisoRol) {

	    boolean existe = permisosRolService.existePermisosRol(permisoRol);

	    if (existe) {
	        return new ResponseEntity<>("El Permiso para este rol ya ha sido registrado.", HttpStatus.BAD_REQUEST);
	    } else {
	        permisosRolService.registrarPermisoRol(permisoRol);
	        return new ResponseEntity<>("Permiso registrado con éxito.", HttpStatus.CREATED);
	    }
	}

	
	@GetMapping("/obtener/{idRol}/{idSubMenu}")
	public ResponseEntity<PermisosRol> obtenerPermisoPorId(
	        @PathVariable String idRol,
	        @PathVariable Long idSubMenu) {

	    PermisosRolId permisosRolId = new PermisosRolId(idRol, idSubMenu);

	    Optional<PermisosRol> permisoRol = permisoRolRepository.findById(permisosRolId);

	    if (permisoRol.isPresent()) {
	        return new ResponseEntity<>(permisoRol.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	}
	



}
