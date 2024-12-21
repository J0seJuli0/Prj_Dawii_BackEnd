package com.permisos.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.permisos.modal.dto.*;
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
	
	@GetMapping("/empleado/listarempleadosform")
	public ResponseEntity<?> listarEmpleadosFormato(@RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<EmpleadoDTOForm> empleados = adminService.listarEmpleadosFormato(authorizationHeader);

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
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<PermisosRolDTO> permisosRol = adminService.listarPermisosRol(token);

	        return ResponseEntity.ok(permisosRol);

	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido o mal formado");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
	    }
	
	}
	
	@PutMapping("/permisosrol/actualizar")
    public ResponseEntity<String> actualizarPermiso(@RequestBody ActualizarPermisosRequest request, @RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
        return adminService.actualizarPermiso(request, authorizationHeader);
    }
	
	@GetMapping("/permisosrol/detalles/{idRol}")
    public ResponseEntity<List<DetallePermisoDTO>> obtenerPermisosRolDet(@PathVariable String idRol, @RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
        try {
            List<DetallePermisoDTO> permisos = adminService.BuscarDetallePermiso(idRol, authorizationHeader);

            if (permisos == null || permisos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(permisos);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of(new DetallePermisoDTO("Error", 0, "Error", "N/A", 0, 0, new Date(), new Date())));
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

	@GetMapping("/sub_menu/obtener/{idMenu}")
	public ResponseEntity<?> obtenerSubMenuRol(@PathVariable Long idMenu, @RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
	    try {
	        String token = authorizationHeader.replace("Bearer ", "").trim();
	        if (token.isEmpty()) {
	            return ResponseEntity.badRequest().body("Token vacío");
	        }

	        List<SubMenuDTO> menus = (List<SubMenuDTO>) adminService.BuscarSubMenu(idMenu, authorizationHeader);

	        if (menus.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }

	        return ResponseEntity.ok(menus);

	    } catch (Exception e) {
	        String errorMessage = "Error al obtener submenús: " + e.getMessage();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
	}
	
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

	
	
	// USUARIO
	@PutMapping("/usuario/actualizar-rol")
    public ResponseEntity<String> actualizarRol(@RequestBody Map<String, String> request, @RequestHeader(value = "Authorization", required = true) String authorizationHeader) {
        String idUsuario = request.get("idUsuario");
        String idRol = request.get("idRol");

        String resultado = adminService.actualizarRol(idUsuario, idRol, authorizationHeader);

        if (resultado.equals("Usuario Actualizado Correctamente.")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
    }
	
	
	
	// INICIAR SESION:
	@PostMapping("/usuario/login")
    public ResponseEntity<LoginOutputDTO> login(@RequestBody LoginInputDTO inputDTO) {
		
		return ResponseEntity.ok(adminService.login(inputDTO));

    }
	
}
