package com.permisos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, String> {

}
