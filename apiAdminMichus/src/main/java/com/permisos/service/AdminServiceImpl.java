package com.permisos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
	
	// ROL
	@Override
	public List<RolDTO> listarRol() {
	
		return adminFeign.listarRol();
	}
			
		
	// SUB_MENU
	@Override
	public List<SubMenuDTO> listarSubMenu() {
	
		return adminFeign.listarSubMenu();
	}
			
		
	// TIPO_DOCUMENTO
	public List<TipoDocumentoDTO> listarTipoDocumento() {
		
		return adminFeign.listarTipoDocumento();
	}
		
		
	// USUARIOS_SISTEMA
	public List<UsuariosSistemaDTO> listarUsuariosSistema() {
		
		return adminFeign.listarUsuariosSistema();
	}

}
