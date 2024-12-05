package com.permisos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.permisos.model.entity.PermisosRol;
import com.permisos.model.entity.PermisosRolId;

public interface IPermisoRolRepository extends JpaRepository<PermisosRol, PermisosRolId> {
	List<PermisosRol> findByIdIdRol(String idRol);
}
