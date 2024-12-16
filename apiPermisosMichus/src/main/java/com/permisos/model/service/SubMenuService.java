package com.permisos.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.SubMenus;
import com.permisos.model.repository.ISubMenusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubMenuService {

	private ISubMenusRepository submenusRepository;
	
	public Optional<SubMenus> obtenerPorId(Long isSubMenu){
		return submenusRepository.findById(isSubMenu);
	}
	
	public SubMenus guardar (SubMenus subMenus) {
		return submenusRepository.save(subMenus);
	}
	
	public List<SubMenus> obtenerPorIdMenu(Long idMenu) {
        return submenusRepository.findByIdMenu_IdMenu(idMenu);
    }
}
