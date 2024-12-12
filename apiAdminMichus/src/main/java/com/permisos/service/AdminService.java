package com.permisos.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.permisos.modal.dto.*;

public interface AdminService {
	// EMPLEADOS
	List<EmpleadoDTO>listarEmpleados();
	
	
	// MENU
	List<MenuDTO>listarMenu();
	
	
	// PERMISOS_ROL
	List<PermisosRolDTO>listarPermisosRol();
	
	ResponseEntity<String> registrarPermisoRol(@RequestBody PermisosRolDTO permisoRol);
	
	
	// ROL
	List<RolDTO>listarRol();
		
	ResponseEntity<RolDTO> registrarRol(@RequestBody RolDTO rol);

	ResponseEntity<RolDTO> actualizarRol(@PathVariable("idRol") String idRol, @RequestBody RolDTO rol);
	
	
	// SUB_MENU
	List<SubMenuDTO>listarSubMenu();
		
	ResponseEntity<SubMenuDTO> actualizarSubMenu(@PathVariable("idSubMenus") Long idSubMenus, @RequestBody SubMenuDTO submenu);
	
	
	// TIPO_DOCUMENTO
	List<TipoDocumentoDTO>listarTipoDocumento();
	
	
	// USUARIOS_SISTEMA
	List<UsuariosSistemaDTO>listarUsuariosSistema();
	
	
	
	// LOGIN
	Map<String, Object> login(String email, String contrasenia);
}
