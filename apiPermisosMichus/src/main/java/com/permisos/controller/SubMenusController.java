package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.SubMenus;
import com.permisos.model.repository.ISubMenusRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/subMenus")
@AllArgsConstructor
public class SubMenusController {

	private ISubMenusRepository subMenusRepository;
	
	@GetMapping("/listar")
	public List<SubMenus> listar(){
		return subMenusRepository.findAll();
	}
}
