package com.permisos.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.permisos.model.dto.EmpleadosDTO;
import com.permisos.model.repository.IUsuariosSistemaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpleadosService {

	private IUsuariosSistemaRepository usuariosSistemaRepository;
	
	public List<EmpleadosDTO> obtenerEmpleados() {
	    List<Object[]> empleadosRaw = usuariosSistemaRepository.getListaEmpleados();
	    List<EmpleadosDTO> empleadosDTO = new ArrayList<>();

	    for (Object[] row : empleadosRaw) { 
	    	String codigo = (String) row [0];
	        String nombres = (String) row[1];
	        String apellidos = (String) row[2];
	        String documento = (String) row[3];
	        String numDoc = (String) row[4];
	         
	        Object fechaIngresoObject = row[5];
	        String fechaIngreso = "";
	        if (fechaIngresoObject instanceof java.sql.Timestamp) {
	            java.sql.Timestamp timestamp = (java.sql.Timestamp) fechaIngresoObject;
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            fechaIngreso = dateFormat.format(timestamp);  
	        } else {
	            fechaIngreso = (String) fechaIngresoObject;
	        }
 
	        String estado = null;
	        Object estadoObject = row[6];
	        if (estadoObject instanceof Byte) {
	            estado = (estadoObject != null) ? String.valueOf(estadoObject) : null;
	        } else {
	            estado = (String) estadoObject;  
	        }

	        String rol = (String) row[7];
 
	        EmpleadosDTO empleadoDTO = new EmpleadosDTO(codigo ,nombres, apellidos, documento, numDoc, 
	                                                  fechaIngreso, estado, rol);
	        empleadosDTO.add(empleadoDTO);
	    }

	    return empleadosDTO;
	}


}
