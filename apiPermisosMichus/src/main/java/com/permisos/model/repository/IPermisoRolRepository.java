package com.permisos.model.repository;

import java.util.List;

import com.permisos.model.entity.PermisosRol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IPermisoRolRepository extends JpaRepository<PermisosRol, PermisosRol.PermisosRolId> {

		List<PermisosRol> findByIdRol(String idRol);
	 
		@Modifying
		@Transactional
		@Query("UPDATE PermisosRol pr SET pr.idSubmenu = :newIdSubmenu WHERE pr.idRol = :idRol AND pr.idSubmenu = :idSubmenu")
		int updateSubmenu(String idRol, Integer idSubmenu, Integer newIdSubmenu);

}
