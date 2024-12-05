package com.permisos.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.permisos.modal.dto.*;

@FeignClient(name="apiPermisosMichus")
public interface AdminFeignClient {
	
	// EMPLEADOS
	@GetMapping("/empleado/listar")
	public List<EmpleadoDTO> listarEmpleado();
	
	// MENU
	@GetMapping("/menu/listar")
	public List<MenuDTO> listarMenu();

	// PERMISOS_ROL
	@GetMapping("/permisosRol/listar")
	public List<PermisosRolDTO> listarPermisosRol();
	
	// ROL
	@GetMapping("/rol/listar")
	public List<RolDTO> listarRol();
	
	// SUB_MENUS
	@GetMapping("/subMenus/listar")
	public List<SubMenuDTO> listarSubMenu();
	
	// TIPO_DOCUMENTO
	@GetMapping("/tipoDocumento/listar")
	public List<TipoDocumentoDTO> listarTipoDocumento();
		
	// USUARIOSSISTEMA
	@GetMapping("/usuariosSistema/listar")
	public List<UsuariosSistemaDTO> listarUsuariosSistema();

	// LOGIN_
	@PostMapping("/api/login")
    Map<String, Object> login(@RequestParam("email") String email, 
                              @RequestParam("contrasenia") String contrasenia); 

}
