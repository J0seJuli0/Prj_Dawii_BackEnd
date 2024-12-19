package com.permisos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.permisos.modal.dto.EmpleadoDTO;
import com.permisos.modal.dto.LoginInputDTO;
import com.permisos.modal.dto.LoginOutputDTO;
import com.permisos.modal.dto.MenuDTO;
import com.permisos.modal.dto.PermisosRolDTO;
import com.permisos.modal.dto.RolDTO;
import com.permisos.modal.dto.SubMenuDTO;
import com.permisos.modal.dto.TipoDocumentoDTO;

public interface AdminService {

	// EMPLEADOS
	List<EmpleadoDTO>listarEmpleados(String authorizationHeader);
	
	
	
	// MENU
	List<MenuDTO>listarMenu(String authorizationHeader);
	
	
	
	// PERMISOS_ROL
	List<PermisosRolDTO>listarPermisosRol(String authorizationHeader);
		
	ResponseEntity<String> registrarPermisoRol(@RequestBody PermisosRolDTO permisoRol, String authorizationHeader);

	PermisosRolDTO BuscarPermisosRol(String idRol, Long idSubMenu, String authorizationHeader);
	
	
	
	// ROL
	List<RolDTO>listarRol(String authorizationHeader);
		
	ResponseEntity<RolDTO> registrarRol(@RequestBody RolDTO rol, String authorizationHeader);

	RolDTO BuscarRol(String idRol, String authorizationHeader);
	
	
	
	// SUB_MENU
	List<SubMenuDTO>listarSubMenu(String authorizationHeader);
		
    ResponseEntity<String> actualizarSubMenu(Long idSubMenus, SubMenuDTO submenu, String authorizationHeader);
	
	List<SubMenuDTO> BuscarSubMenu(Long idMenu, String authorizationHeader);
	
	
	
	// TIPO_DOCUMENTO
	List<TipoDocumentoDTO>listarTipoDocumento(String authorizationHeader);

	
	
	// USUARIO
	String actualizarRol(String idUsuario, String idRol, String authorizationHeader);
	
	
	
	// LOGIN
	LoginOutputDTO login (LoginInputDTO inputDTO);
}
