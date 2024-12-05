package com.permisos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.SubMenus;
import com.permisos.model.repository.ISubMenusRepository;
import com.permisos.service.SubMenuService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/subMenus")
@AllArgsConstructor
public class SubMenusController {

	private ISubMenusRepository subMenusRepository;
	private SubMenuService subMenuService;
	
	@GetMapping("/listar")
	public List<SubMenus> listar(){
		return subMenusRepository.findAll();
	}
	
	@PutMapping("actualizar/{idSubMenus}")
	public ResponseEntity<SubMenus> actualizar(@PathVariable Long idSubMenus, @RequestBody SubMenus submenu){
		Optional<SubMenus> subMenuExiste = subMenuService.obtenerPorId(idSubMenus);
		
		if (subMenuExiste.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		SubMenus subMenuActualizado = subMenuExiste.get();
		
		if (submenu.getNombreSubMenu() != null) {
			subMenuActualizado.setNombreSubMenu(submenu.getNombreSubMenu());
		}
		
		if (submenu.getEnlaceSubMenu() != null) {
			subMenuActualizado.setEnlaceSubMenu(submenu.getEnlaceSubMenu());
	    }
	    if (submenu.getOrdenSubMenu() != null) {
	    	subMenuActualizado.setOrdenSubMenu(submenu.getOrdenSubMenu());
	    }
	    if (submenu.getEstadoSubMenu() != null) {
	    	subMenuActualizado.setEstadoSubMenu(submenu.getEstadoSubMenu());
	    }
	    if (submenu.getFechaCreacion() != null) {
	    	subMenuActualizado.setFechaCreacion(submenu.getFechaCreacion());
	    }
	    if (submenu.getFechaModificacion() != null) {
	    	subMenuActualizado.setFechaModificacion(submenu.getFechaModificacion());
	    }
	    if (submenu.getIdMenu() != null) {
	    	subMenuActualizado.setIdMenu(submenu.getIdMenu());
	    }
	    
	    subMenuService.guardar(subMenuActualizado);
	    
	    return new ResponseEntity<>(subMenuActualizado, HttpStatus.OK);
	}
}
