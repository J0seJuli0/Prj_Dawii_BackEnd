package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.PermisosRol;
import com.permisos.model.repository.IPermisoRolRepository;

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
}
