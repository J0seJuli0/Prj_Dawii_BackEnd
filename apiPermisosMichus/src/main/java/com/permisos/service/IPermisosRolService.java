package com.permisos.service;

import org.springframework.stereotype.Service;

import com.permisos.model.entity.PermisosRol;
import com.permisos.model.repository.IPermisoRolRepository;
import com.permisos.model.repository.IRolRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IPermisosRolService {

	private IPermisoRolRepository permisoRolRepository;
	
	public PermisosRol registrarPermisoRol (PermisosRol permisosRol) {
		return permisoRolRepository.save(permisosRol);
	}
}
