package com.permisos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.modal.dto.EmpleadoDTO;
import com.permisos.modal.dto.LoginInputDTO;
import com.permisos.modal.dto.LoginOutputDTO;
import com.permisos.modal.dto.MenuDTO;
import com.permisos.modal.dto.PermisosRolDTO;
import com.permisos.modal.dto.RolDTO;
import com.permisos.modal.dto.SubMenuDTO;
import com.permisos.modal.dto.TipoDocumentoDTO;
import com.permisos.modal.dto.UsuariosSistemaDTO;
import com.permisos.service.AdminService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	// EMPLEADOS
	@GetMapping("/empleado/listarempleado")
	public ResponseEntity<?> listarEmpleados(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<EmpleadoDTO> empleados = adminService.listarEmpleados(authorizationHeader);

	        return ResponseEntity.ok(empleados);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}

	
	// MENU
	@GetMapping("/menu/listarmenu")
	public ResponseEntity<?> listarMenu(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<MenuDTO> menu = adminService.listarMenu(authorizationHeader); 
	        return ResponseEntity.ok(menu);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}

	
	// PERMISOS_ROL
	@GetMapping("/permisosrol/listarpermisorol")
	public ResponseEntity<?> listarPermisosRol(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        // Verificar si el encabezado contiene un token válido
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        // Llamar al servicio para obtener los permisos
	        List<PermisosRolDTO> permisosRol = adminService.listarPermisosRol(token);

	        return ResponseEntity.ok(permisosRol);

	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido o mal formado");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
	    }
	
	}

	@PostMapping("/permisosrol/crearpermisosrol")
	public ResponseEntity<?> crearPermisoRol(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @RequestBody PermisosRolDTO permisoRol) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        return adminService.registrarPermisoRol(permisoRol, authorizationHeader);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}
	
	@GetMapping("/permisosrol/obtener/{idRol}/{idSubMenu}")
	public ResponseEntity<?> obtenerPermisosRol(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String idRol, @PathVariable Long idSubMenu) {
	    try {
	    	 String token = authorizationHeader.replace("Bearer ", "").trim();
		        if (token.isEmpty()) {
		            return ResponseEntity.badRequest().body("Token vacío");
		        }
	        PermisosRolDTO permisosRol = adminService.BuscarPermisosRol(idRol, idSubMenu, authorizationHeader);
	        return ResponseEntity.ok(permisosRol);
	    } catch (Exception e) {
	        // Devuelve el mensaje del error en la respuesta para depuración
	        String errorMessage = "Error al obtener permisos: " + e.getMessage();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
	}

	
	
	// ROL
	@GetMapping("/rol/listarrol")
	public ResponseEntity<?> listarRol(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<RolDTO> roles = adminService.listarRol(authorizationHeader); 
	        return ResponseEntity.ok(roles);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}

	@PostMapping("/rol/crearrol")
	public ResponseEntity<?> crearRol(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @RequestBody RolDTO rol) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        return adminService.registrarRol(rol, authorizationHeader);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}

	@GetMapping("/rol/obtener/{id}")
	public ResponseEntity<?> obtenerRol(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id) {
	    try {
	    	 String token = authorizationHeader.replace("Bearer ", "").trim();
		        if (token.isEmpty()) {
		            return ResponseEntity.badRequest().body("Token vacío");
		        }
	        RolDTO Rol = adminService.BuscarRol(id, authorizationHeader);
	        return ResponseEntity.ok(Rol);
	    } catch (Exception e) {
	        // Devuelve el mensaje del error en la respuesta para depuración
	        String errorMessage = "Error al obtener permisos: " + e.getMessage();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
	}
	
	
	
	// SUB_MENU
	@GetMapping("/sub_menu/listarsubmenu")
	public ResponseEntity<?> listarSubMenu(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<SubMenuDTO> subMenus = adminService.listarSubMenu(authorizationHeader); 
	        return ResponseEntity.ok(subMenus);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}

	
	
	// ----- NO FUNCIONA ----
	@PutMapping("/sub_menu/actualizar/{idSubMenus}")
    public ResponseEntity<String> actualizarSubMenu(@PathVariable("idSubMenus") Long idSubMenus, @RequestBody SubMenuDTO submenu, @RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
        return adminService.actualizarSubMenu(idSubMenus, submenu, authorizationHeader);
    }

	
	
	
	
	
	// TIPO_DOCUMENTO
	@GetMapping("/tipo_documento/listartipodocumento")
	public ResponseEntity<?> listarTipoDocumento(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<TipoDocumentoDTO> tipoDocumentos = adminService.listarTipoDocumento(authorizationHeader); 
	        return ResponseEntity.ok(tipoDocumentos);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TOKEN NO VALIDO");
	    }
	}

	
	
	
	
	
	// INICIAR SESION:
	@PostMapping("/usuario/login")
    public ResponseEntity<LoginOutputDTO> login(@RequestBody LoginInputDTO inputDTO) {
		
		return ResponseEntity.ok(adminService.login(inputDTO));

    }
	
}


//-------------------------------- 17/12/2024
