package com.permisos.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.permisos.modal.dto.*;

@FeignClient(name="apiPermisosMichus")
public interface AdminFeignClient {
	
	// EMPLEADOS
	@GetMapping("/empleado/listar")
	public List<EmpleadoDTO> listarEmpleado(@RequestHeader("Authorization") String authorizationHeader);
	
	@GetMapping("/empleado/empleados")
	public List<EmpleadoDTOForm> listarEmpleadosFormato(@RequestHeader("Authorization") String authorizationHeader);
	
	
	
	// MENU
	@GetMapping("/menu/listar")
	public List<MenuDTO> listarMenu(@RequestHeader("Authorization") String authorizationHeader);
	
	
	
	// PERMISOS_ROL
	@GetMapping("/permisosRol/listar")
	List<PermisosRolDTO> listarPermisosRol(@RequestHeader("Authorization") String authorizationHeader);
	
	@PutMapping("/permisosRol/actualizar")
	ResponseEntity<String> actualizarPermiso(@RequestBody ActualizarPermisosRequest request, @RequestHeader("Authorization") String authorizationHeader);
	
	@GetMapping("/permisosRol/detalles/{idRol}")
	List<DetallePermisoDTO> listarDetallePermiso(@PathVariable("idRol") String idRol, @RequestHeader("Authorization") String authorizationHeader);
	
	
	// ROL
	@GetMapping("/rol/listar")
	public List<RolDTO> listarRol(@RequestHeader("Authorization") String authorizationHeader);
	
	@PostMapping("/rol/registrar")
    ResponseEntity<RolDTO> registrarRol(@RequestBody RolDTO rol, @RequestHeader("Authorization") String authorizationHeader);
	
	@GetMapping("/rol/obtener/{id}")
	RolDTO obtenerRolPorId(@PathVariable("id") String id, @RequestHeader("Authorization") String authorizationHeader);

	
	
	// SUB_MENUS
	@GetMapping("/subMenus/listar")
	public List<SubMenuDTO> listarSubMenu(@RequestHeader("Authorization") String authorizationHeader);
	
	@PutMapping("/subMenus/actualizar/{idSubMenus}")
    ResponseEntity<String> actualizarSubMenu(@PathVariable Long idSubMenus, @RequestBody SubMenuDTO submenu, @RequestHeader("Authorization") String authorizationHeader);
	
	@GetMapping("/subMenus/listarPorMenu/{idMenu}")
	List<SubMenuDTO> listarSubMenusPorMenu(@PathVariable("idMenu") Long idMenu, @RequestHeader("Authorization") String authorizationHeader);
	

	
	// TIPO_DOCUMENTO
	@GetMapping("/tipoDocumento/listar")
	public List<TipoDocumentoDTO> listarTipoDocumento(@RequestHeader("Authorization") String authorizationHeader);
		
	
	
	// USUARIO
	@PutMapping("/usuarios/actualizar-rol")
    ResponseEntity<String> actualizarUsuario(@RequestBody Map<String, String> request, @RequestHeader("Authorization") String authorizationHeader);
	


	// LOGIN_
	@PostMapping("/api/usuario/login")
    public LoginOutputDTO login(@RequestBody LoginInputDTO inputDTO);
	}
