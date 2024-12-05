package com.permisos.model.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class ILoginRepository {

	private JdbcTemplate jdbcTemplate;
	
	public ILoginRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public Map<String, Object> login(String email, String contrasenia){
		 SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
	                .withProcedureName("sp_login_usuario") 
	                .declareParameters(
	                		new SqlParameter("p_email", Types.VARCHAR),
	                        new SqlParameter("p_contrasenia", Types.VARCHAR),
	                        new SqlOutParameter("p_mensaje", Types.VARCHAR),
	                        new SqlOutParameter("p_usuario_id", Types.VARCHAR),
	                        new SqlOutParameter("p_rol", Types.VARCHAR),
	                        new SqlOutParameter("p_tipo_usuario", Types.TINYINT)
	                );
		
		 	Map<String, Object> result = simpleJdbcCall.execute(
		 			email,
		 			contrasenia
		 	);
		 	return result;
	}
}
