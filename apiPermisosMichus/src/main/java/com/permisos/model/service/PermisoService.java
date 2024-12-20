package com.permisos.model.service;

import com.permisos.model.dto.DetallePermisoDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private EntityManager entityManager;

    public List<DetallePermisoDTO> listarDetallesPorRol(String idRol) { 
        String sql = "EXEC ListarDetallesPorRol :idRol"; 
 
        List<Object[]> result = entityManager.createNativeQuery(sql)
                                             .setParameter("idRol", idRol)
                                             .getResultList();

        // Mapear los resultados a DTO
        List<DetallePermisoDTO> detalles = new ArrayList<>();
        for (Object[] row : result) {
            String rol = (String) row[0];
            Integer submenuId = (Integer) row[1];
            String nombreSubmenu = (String) row[2];
            String enlaceSubmenu = (String) row[3];
            Integer ordenSubmenu = (Integer) row[4];
            Integer estadoSubmenu = (Integer) row[5];
 
            Date fechaCreacionSubmenu = ((Timestamp) row[6]).getTime() != 0 ? new Date(((Timestamp) row[6]).getTime()) : null;
            Date fechaModificacionSubmenu = ((Timestamp) row[7]).getTime() != 0 ? new Date(((Timestamp) row[7]).getTime()) : null;

            DetallePermisoDTO detalle = new DetallePermisoDTO(
                    rol, submenuId, nombreSubmenu, enlaceSubmenu,
                    ordenSubmenu, estadoSubmenu, fechaCreacionSubmenu, fechaModificacionSubmenu
            );
            detalles.add(detalle);
        }

        return detalles;
    }
}
