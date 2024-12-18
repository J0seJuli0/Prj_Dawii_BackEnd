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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.PermisosRol;
import com.permisos.model.entity.SubMenus;
import com.permisos.model.repository.ISubMenusRepository;
import com.permisos.model.service.IPermisosRolService;
import com.permisos.model.service.SubMenuService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/subMenus")
@AllArgsConstructor
public class SubMenusController {

	private ISubMenusRepository subMenusRepository;
	private SubMenuService subMenuService;
	private IPermisosRolService permisosRolService;
	
	@GetMapping("/listar")
	public List<SubMenus> listar(){
		return subMenusRepository.findAll();
	}
	
	@PutMapping("/actualizar/{idSubMenus}")
	public ResponseEntity<?> actualizar(@PathVariable Long idSubMenus, @RequestBody SubMenus submenu){
		Optional<SubMenus> subMenuExiste = subMenuService.obtenerPorId(idSubMenus);
		
		if (subMenuExiste.isEmpty()) {
			return new ResponseEntity<>("Sub menu no encontrado.",HttpStatus.NOT_FOUND);
		}
		
		SubMenus subMenuActualizado = subMenuExiste.get();
		
		if (submenu.getEstadoSubMenu() != null) {
			if (submenu.getEstadoSubMenu() != 0 && submenu.getEstadoSubMenu() !=1) {
				return new ResponseEntity<>("El estado debe ser 0 o 1.", HttpStatus.BAD_REQUEST);
			}
	    	subMenuActualizado.setEstadoSubMenu(submenu.getEstadoSubMenu());
	    }else {
	    	return new ResponseEntity<>("Error al actualizar el estado.",HttpStatus.BAD_REQUEST);
	    }
		
	    subMenuService.guardar(subMenuActualizado);
	    
	    return new ResponseEntity<>("Estado actualizado correctamente.", HttpStatus.OK);
	}
	
	@GetMapping("/listarPorMenu/{idMenu}")
    public ResponseEntity<List<SubMenus>> listarSubMenusPorMenu(@PathVariable Long idMenu) {
        List<SubMenus> subMenus = subMenuService.obtenerPorIdMenu(idMenu);
        
        if (subMenus.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(subMenus);
    }
}
