package com.permisos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.Menu;

public interface IMenuRepository extends JpaRepository<Menu, Long> {

}
