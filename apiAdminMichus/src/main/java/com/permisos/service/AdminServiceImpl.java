package com.permisos.service;

import java.util.List;

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
	public List<EmpleadoDTO> listarEmpleados(String authorizationHeader) {
	
		return adminFeign.listarEmpleado(authorizationHeader);
	}

	
	// MENU
	@Override
	public List<MenuDTO> listarMenu(String authorizationHeader) {
	
		return adminFeign.listarMenu(authorizationHeader);
	}
		
	
	@Override
	public List<PermisosRolDTO> listarPermisosRol(String authorizationHeader) {
	    // Asegurarte de que tiene el prefijo "Bearer"
	    if (!authorizationHeader.startsWith("Bearer ")) {
	        authorizationHeader = "Bearer " + authorizationHeader.trim();
	    }

	    // Llamada al Feign Client
	    return adminFeign.listarPermisosRol(authorizationHeader);
	}
	

	
		
	@Override
	public ResponseEntity<String> registrarPermisoRol(PermisosRolDTO permisoRol, String authorizationHeader) {
		return adminFeign.registrarPermisoRol(permisoRol, authorizationHeader);
	}
	
	@Override
	public PermisosRolDTO BuscarPermisosRol(String idRol, Long idSubMenu, String authorizationHeader) {
	    return adminFeign.obtenerPermisosPorId(idRol, idSubMenu, authorizationHeader);
	}
	


	
	
	// ROL
	@Override
	public List<RolDTO> listarRol(String authorizationHeader) {
	
		return adminFeign.listarRol(authorizationHeader);
	}

	@Override
	public ResponseEntity<RolDTO> registrarRol(RolDTO rol, String authorizationHeader) {
		return adminFeign.registrarRol(rol, authorizationHeader);
	}

	
	@Override
	public RolDTO BuscarRol(String idRol, String authorizationHeader) {
		return adminFeign.obtenerRolPorId(idRol, authorizationHeader);
	}


	
	
	// SUB_MENU
	@Override
	public List<SubMenuDTO> listarSubMenu(String authorizationHeader) {
	
		return adminFeign.listarSubMenu(authorizationHeader);
	}
	
	@Override
    public ResponseEntity<String> actualizarSubMenu(Long idSubMenus, SubMenuDTO submenu, String authorizationHeader) {
        return adminFeign.actualizarSubMenu(idSubMenus, submenu, authorizationHeader);
    }
	
			
		
	// TIPO_DOCUMENTO
	public List<TipoDocumentoDTO> listarTipoDocumento(String authorizationHeader) {
		
		return adminFeign.listarTipoDocumento(authorizationHeader);
	}
	

	@Override
	public LoginOutputDTO login(LoginInputDTO inputDTO) {
		return adminFeign.login(inputDTO);
	}


	

	

}
