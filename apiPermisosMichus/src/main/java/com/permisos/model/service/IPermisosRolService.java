package com.permisos.model.service;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.PermisosRol;
import com.permisos.model.repository.IPermisoRolRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IPermisosRolService {

	private IPermisoRolRepository permisoRolRepository;
	
	public PermisosRol registrarPermisoRol (PermisosRol permisosRol) {
		return permisoRolRepository.save(permisosRol);
	}

	public boolean existePermisosRol(PermisosRol permisoRol) {
		return permisoRolRepository.existsById(permisoRol.getId());
	}
	


}
