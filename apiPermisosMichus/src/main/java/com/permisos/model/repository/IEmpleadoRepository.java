package com.permisos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, String> {

}
