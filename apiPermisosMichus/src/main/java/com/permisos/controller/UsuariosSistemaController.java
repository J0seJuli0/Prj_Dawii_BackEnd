package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.permisos.model.entity.UsuariosSistema;
import com.permisos.model.repository.IUsuariosSistemaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuariosSistema")
@AllArgsConstructor
public class UsuariosSistemaController {

	private IUsuariosSistemaRepository usuariosSistemaRepository;
	
	@GetMapping("/listar")
	public List<UsuariosSistema> lista(){
		return usuariosSistemaRepository.findAll();
	}
}
