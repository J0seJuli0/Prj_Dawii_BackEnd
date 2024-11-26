package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.Empleado;
import com.permisos.model.repository.IEmpleadoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/empleado")
@AllArgsConstructor
public class EmpleadoController {

	private IEmpleadoRepository empleadoRepository;
	
	@GetMapping("/listar")
	public List<Empleado> listar(){
		return empleadoRepository.findAll();
	}
}
