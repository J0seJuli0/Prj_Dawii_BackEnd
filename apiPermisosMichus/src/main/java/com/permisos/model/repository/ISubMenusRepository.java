package com.permisos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.SubMenus;

public interface ISubMenusRepository extends JpaRepository<SubMenus, Long> {

	List<SubMenus> findByIdMenu_IdMenu(Long idMenu);
}
