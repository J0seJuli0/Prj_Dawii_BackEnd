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
	        // Mapea cada columna del resultado a los campos correspondientes del DTO
	        String nombres = (String) row[0];
	        String apellidos = (String) row[1];
	        String documento = (String) row[2];
	        String numDoc = (String) row[3];
	        
	        // Maneja la conversión de fecha si es necesario
	        Object fechaIngresoObject = row[4];
	        String fechaIngreso = "";
	        if (fechaIngresoObject instanceof java.sql.Timestamp) {
	            java.sql.Timestamp timestamp = (java.sql.Timestamp) fechaIngresoObject;
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            fechaIngreso = dateFormat.format(timestamp);  // Convierte el Timestamp a String
	        } else {
	            fechaIngreso = (String) fechaIngresoObject;
	        }

	        // Verifica si el valor es un Byte para evitar el ClassCastException
	        String estado = null;
	        Object estadoObject = row[5];
	        if (estadoObject instanceof Byte) {
	            estado = (estadoObject != null) ? String.valueOf(estadoObject) : null;
	        } else {
	            estado = (String) estadoObject;  // Si ya es String, no es necesario hacer conversión
	        }

	        String rol = (String) row[6];

	        // Crea el objeto EmpleadoDTO
	        EmpleadosDTO empleadoDTO = new EmpleadosDTO(nombres, apellidos, documento, numDoc, 
	                                                  fechaIngreso, estado, rol);
	        empleadosDTO.add(empleadoDTO);
	    }

	    return empleadosDTO;
	}


}
