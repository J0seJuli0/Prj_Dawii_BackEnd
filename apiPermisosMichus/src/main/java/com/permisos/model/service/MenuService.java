package com.permisos.model.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.Menu;
import com.permisos.model.repository.IMenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	private IMenuRepository menuRepository;
	
	public Optional<Menu> obtenerPorId(Long idMenu){
		return menuRepository.findById(idMenu);
	}
	
	public Menu guardar(Menu menu) {
		return menuRepository.save(menu);
	}
}
