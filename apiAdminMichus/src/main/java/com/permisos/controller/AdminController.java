package com.permisos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/listarempleado")
    public List<EmpleadoDTO> listarEstudiantes() {
        return adminService.listarEmpleados(); 
    }

	
	// MENU -- LISTO
	@GetMapping("/listarmenu")
    public List<MenuDTO> listarMenu() {
        return adminService.listarMenu(); 
    }
	
	
	// PERMISOS_ROL -- LISTO
	@GetMapping("/listarpermisosrol")
    public List<PermisosRolDTO> listarPermisosRol() {
        return adminService.listarPermisosRol(); 
    }
	
	
	// ROL -- LISTO
	@GetMapping("/listarrol")
    public List<RolDTO> listarRol() {
        return adminService.listarRol(); 
    }
	
	
	// SUB_MENU -- LISTO
	@GetMapping("/listarsubmenu")
    public List<SubMenuDTO> listarSubMenu() {
        return adminService.listarSubMenu(); 
    }
	
	
	// TIPO_DOCUMENTO -- LISTO
	@GetMapping("/listartipodocumento")
    public List<TipoDocumentoDTO> listarTipoDocumento() {
        return adminService.listarTipoDocumento(); 
    }
	
	
	// USUARIOS_SISTEMA -- LISTO
	@GetMapping("/listarusuariosistema")
    public List<UsuariosSistemaDTO> listarUsuariosSistema() {
        return adminService.listarUsuariosSistema(); 
    }

	
	
	// INICIAR SESION:
	@PostMapping
    public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String contrasenia) {
        Map<String, Object> result = adminService.login(email, contrasenia);

        return ResponseEntity.ok(result);
    }
	
}
