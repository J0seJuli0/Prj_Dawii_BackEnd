package com.permisos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.UsuariosSistema;

public interface IUsuariosSistemaRepository extends JpaRepository<UsuariosSistema, String> {

}
