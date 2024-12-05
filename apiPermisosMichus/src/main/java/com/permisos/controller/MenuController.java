package com.permisos.controller;

import java.util.List;
	import java.util.Optional;
	
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.Menu;
import com.permisos.model.repository.IMenuRepository;
import com.permisos.service.MenuService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class MenuController {

	private IMenuRepository menuRepository;
	private MenuService menuService;
	@GetMapping("/listar")
	public List<Menu> listar(){
		return menuRepository.findAll();
	}
	
	

}
