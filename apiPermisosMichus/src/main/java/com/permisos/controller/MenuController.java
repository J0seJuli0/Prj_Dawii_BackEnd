package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.Menu;
import com.permisos.model.repository.IMenuRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuController {

	private IMenuRepository menuRepository;
	
	@GetMapping("/listar")
	public List<Menu> listar(){
		return menuRepository.findAll();
	}
}