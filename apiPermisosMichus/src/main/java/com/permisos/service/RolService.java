package com.permisos.service;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.Rol;
import com.permisos.model.repository.IRolRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolService {

	private IRolRepository iRolRepository;
	
	public Rol registrarRol(Rol rol) {
		
		return iRolRepository.save(rol);
	}
}
