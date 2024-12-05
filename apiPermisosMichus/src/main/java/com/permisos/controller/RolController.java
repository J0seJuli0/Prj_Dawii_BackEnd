package com.permisos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.Rol;
import com.permisos.model.repository.IRolRepository;
import com.permisos.service.RolService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rol")
@AllArgsConstructor
public class RolController {

	private IRolRepository rolRepository;
	
	private RolService rolService;
	
	@GetMapping("/listar")
	public List<Rol> listar(){
		return rolRepository.findAll();
	}
		
	@PostMapping("/registrar")
	public ResponseEntity<Rol> registrarRol(@RequestBody Rol rol){
		Rol rolRegistrado = rolService.registrarRol(rol);
		return new ResponseEntity<>(rolRegistrado, HttpStatus.CREATED);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Rol> obtenerRolPorId(@PathVariable String id){
		Optional<Rol> rol = rolRepository.findById(id);
		if (rol.isPresent()) {
			return new ResponseEntity<>(rol.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable String id, @RequestBody Rol rol) {
        Optional<Rol> rolExistente = rolRepository.findById(id);
        if (rolExistente.isPresent()) {
            Rol rolActualizado = rolExistente.get();
            rolActualizado.setRol(rol.getRol());
            Rol updatedRol = rolRepository.save(rolActualizado);
            return new ResponseEntity<>(updatedRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
