package com.permisos.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.permisos.client.AdminFeignClient;
import com.permisos.modal.dto.*;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminFeignClient adminFeign;
	
	// EMPLEADOS
	@Override
	public List<EmpleadoDTO> listarEmpleados() {
	
		return adminFeign.listarEmpleado();
	}

	
	// MENU
	@Override
	public List<MenuDTO> listarMenu() {
	
		return adminFeign.listarMenu();
	}
		
	
	// PERMISOS_ROL
	@Override
	public List<PermisosRolDTO> listarPermisosRol() {
	
		return adminFeign.listarPermisosRol();
	}
		
	@Override
	public ResponseEntity<String> registrarPermisoRol(PermisosRolDTO permisoRol) {
		return adminFeign.registrarPermisoRol(permisoRol);
	}
	
	
	
	// ROL
	@Override
	public List<RolDTO> listarRol() {
	
		return adminFeign.listarRol();
	}

	@Override
	public ResponseEntity<RolDTO> registrarRol(RolDTO rol) {
		return adminFeign.registrarRol(rol);
	}
	
	
	@Override
	public ResponseEntity<RolDTO> actualizarRol(String idRol, RolDTO rol) {
		return adminFeign.actualizarRol(idRol, rol);
	}

	
	
	// SUB_MENU
	@Override
	public List<SubMenuDTO> listarSubMenu() {
	
		return adminFeign.listarSubMenu();
	}
	
	@Override
	public ResponseEntity<SubMenuDTO> actualizarSubMenu(Long idSubMenus, SubMenuDTO submenu) {
		return adminFeign.actualizarSubMenu(idSubMenus, submenu);
	}
	
			
		
	// TIPO_DOCUMENTO
	public List<TipoDocumentoDTO> listarTipoDocumento() {
		
		return adminFeign.listarTipoDocumento();
	}
		
		
	// USUARIOS_SISTEMA
	public List<UsuariosSistemaDTO> listarUsuariosSistema() {
		
		return adminFeign.listarUsuariosSistema();
	}
	
	
	@Override
    public Map<String, Object> login(String email, String contrasenia) {
      return adminFeign.login(email, contrasenia);
    }

}
