package com.permisos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.permisos.client.AdminFeignClient;
import com.permisos.modal.dto.EmpleadoDTO;
import com.permisos.modal.dto.LoginInputDTO;
import com.permisos.modal.dto.LoginOutputDTO;
import com.permisos.modal.dto.MenuDTO;
import com.permisos.modal.dto.PermisosRolDTO;
import com.permisos.modal.dto.RolDTO;
import com.permisos.modal.dto.SubMenuDTO;
import com.permisos.modal.dto.TipoDocumentoDTO;

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
	    if (!authorizationHeader.startsWith("Bearer ")) {
	        authorizationHeader = "Bearer " + authorizationHeader.trim();
	    }
	    return adminFeign.listarPermisosRol(authorizationHeader);
	}
	

	
	// PERMISOS ROL	
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
	public ResponseEntity<String> actualizarSubMenu(Long idSubMenus, SubMenuDTO subMenu, String authorizationHeader) {
        return adminFeign.actualizarSubMenu(idSubMenus, subMenu, authorizationHeader);
    }
	
	@Override
	public List<SubMenuDTO> BuscarSubMenu(Long idMenu, String authorizationHeader) {
		return adminFeign.listarSubMenusPorMenu(idMenu, authorizationHeader);
	}
	
	
		
	// TIPO_DOCUMENTO
	public List<TipoDocumentoDTO> listarTipoDocumento(String authorizationHeader) {	
		return adminFeign.listarTipoDocumento(authorizationHeader);
	}
	
	

	// USUARIO
	@Override
    public String actualizarRol(String idUsuario, String idRol, String authorizationHeader) {
        Map<String, String> request = new HashMap<>();
        request.put("idUsuario", idUsuario);
        request.put("idRol", idRol);
        
        ResponseEntity<String> response = adminFeign.actualizarUsuario(request, authorizationHeader);
        
        if (response.getStatusCode() == HttpStatus.OK) {
            return "Usuario Actualizado Correctamente.";
        } else {
            return "Usuario o Rol no encontrado";
        }
	}
	
	
	
	// LOGIN
	@Override
	public LoginOutputDTO login(LoginInputDTO inputDTO) {
		return adminFeign.login(inputDTO);
	}

}
