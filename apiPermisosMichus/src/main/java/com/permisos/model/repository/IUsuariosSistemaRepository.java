package com.permisos.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.UsuariosSistema;

public interface IUsuariosSistemaRepository extends JpaRepository<UsuariosSistema, String> {

	Optional<UsuariosSistema> findByEmail(String email);
	
	UsuariosSistema findByIdUsuario(String idUsuario);

	@Query(value = "EXEC SP_LISTA_EMPLEADOS_DAWII", nativeQuery = true)
	List<Object[]> getListaEmpleados();

}
