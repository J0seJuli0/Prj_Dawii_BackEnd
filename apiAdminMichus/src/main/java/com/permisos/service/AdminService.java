package com.permisos.service;

import java.util.List;
import java.util.Map;

import com.permisos.modal.dto.*;

public interface AdminService {
	// EMPLEADOS
	List<EmpleadoDTO>listarEmpleados();
	
	// MENU
	List<MenuDTO>listarMenu();
	
	// PERMISOS_ROL
	List<PermisosRolDTO>listarPermisosRol();
	
	// ROL
	List<RolDTO>listarRol();
		
	// SUB_MENU
	List<SubMenuDTO>listarSubMenu();
		
	// TIPO_DOCUMENTO
	List<TipoDocumentoDTO>listarTipoDocumento();
	
	// USUARIOS_SISTEMA
	List<UsuariosSistemaDTO>listarUsuariosSistema();
	
	Map<String, Object> login(String email, String contrasenia);
}
