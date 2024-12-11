package com.permisos.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	
	@PostMapping("/permisosRol/registrar")
	ResponseEntity<String> registrarPermisoRol(@RequestBody PermisosRolDTO permisoRol);
	
	
	// ROL
	@GetMapping("/rol/listar")
	public List<RolDTO> listarRol();
	
	@PostMapping("/rol/registrar")
    ResponseEntity<RolDTO> registrarRol(@RequestBody RolDTO rol);
	
	@GetMapping("/rol/obtener/{idRol}")
    ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable("idRol") String idRol);
	
	@PutMapping("/rol/actualizar/{idRol}")
    ResponseEntity<RolDTO> actualizarRol(@PathVariable("idRol") String idRol, @RequestBody RolDTO rol);
	
	
	// SUB_MENUS
	@GetMapping("/subMenus/listar")
	public List<SubMenuDTO> listarSubMenu();
	
	@PutMapping("/subMenus/actualizar/{idSubMenus}")
    ResponseEntity<SubMenuDTO> actualizarSubMenu(
            @PathVariable("idSubMenus") Long idSubMenus, 
            @RequestBody SubMenuDTO submenu);
	
	
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

