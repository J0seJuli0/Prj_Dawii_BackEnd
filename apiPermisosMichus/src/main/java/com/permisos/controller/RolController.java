package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.Rol;
import com.permisos.model.repository.IRolRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rol")
@AllArgsConstructor
public class RolController {

	private IRolRepository rolRepository;
	
	@GetMapping("/listar")
	public List<Rol> listar(){
		return rolRepository.findAll();
	}
}
