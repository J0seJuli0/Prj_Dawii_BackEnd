package com.permisos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.modal.dto.EmpleadoDTO;
import com.permisos.modal.dto.MenuDTO;
import com.permisos.modal.dto.PermisosRolDTO;
import com.permisos.modal.dto.RolDTO;
import com.permisos.modal.dto.SubMenuDTO;
import com.permisos.modal.dto.TipoDocumentoDTO;
import com.permisos.modal.dto.UsuariosSistemaDTO;
import com.permisos.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
	
	//EMPLEADO -- LISTO
	@GetMapping("/empleado/listarempleado")
    public List<EmpleadoDTO> listarEstudiantes() {
        return adminService.listarEmpleados(); 
    }

	
	// MENU -- LISTO
	@GetMapping("/menu/listarmenu")
    public List<MenuDTO> listarMenu() {
        return adminService.listarMenu(); 
    }
	
	
	// PERMISOS_ROL -- LISTO
	@GetMapping("/permisosrol/listarpermisorol")
    public List<PermisosRolDTO> listarPermisosRol() {
        return adminService.listarPermisosRol(); 
    }
	
	
	@PostMapping("/permisosrol/crearpermisosrol")
    public ResponseEntity<String> crearPermisoRol(@RequestBody PermisosRolDTO permisoRol) {
        return adminService.registrarPermisoRol(permisoRol);
    }
	
	
	// ROL -- LISTO
	@GetMapping("/rol/listarrol")
    public List<RolDTO> listarRol() {
        return adminService.listarRol(); 
    }
	
	@PostMapping("/rol/crearrol")
    public ResponseEntity<RolDTO> crearRol(@RequestBody RolDTO rol) {
        return adminService.registrarRol(rol);
    }
	
	@PutMapping("/rol/actualizarrol/{idRol}")
    public ResponseEntity<RolDTO> actualizarRol(@PathVariable("idRol") String idRol, @RequestBody RolDTO rol) {
        return adminService.actualizarRol(idRol, rol);
    }
	
	
	// SUB_MENU -- LISTO
	@GetMapping("/sub_menu/listarsubmenu")
    public List<SubMenuDTO> listarSubMenu() {
        return adminService.listarSubMenu(); 
    }
	
	@PutMapping("/sub_menu/actualizarsubmenu/{idSubMenus}")
    public ResponseEntity<SubMenuDTO> actualizarSubMenu(@PathVariable("idSubMenus") Long idSubMenus, @RequestBody SubMenuDTO submenu) {
        return adminService.actualizarSubMenu(idSubMenus, submenu);
    }
	
	
	// TIPO_DOCUMENTO -- LISTO
	@GetMapping("/tipo_documento/listartipodocumento")
    public List<TipoDocumentoDTO> listarTipoDocumento() {
        return adminService.listarTipoDocumento(); 
    }
	
	
	// USUARIOS_SISTEMA -- LISTO
	@GetMapping("/usuarios_sistema/listarusuariosistema")
    public List<UsuariosSistemaDTO> listarUsuariosSistema() {
        return adminService.listarUsuariosSistema(); 
    }

	
	
	// INICIAR SESION:
	@PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String contrasenia) {
        Map<String, Object> result = adminService.login(email, contrasenia);

        return ResponseEntity.ok(result);
    }
	
}
