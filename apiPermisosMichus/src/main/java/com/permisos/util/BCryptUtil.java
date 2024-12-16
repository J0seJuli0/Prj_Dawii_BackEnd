package com.permisos.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptUtil {
	private static BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
	
	public String encriptar(String plainText) {
		return passwordEcorder.encode(plainText);
	}

	public Boolean validarPassword(String rawPassword,String encodedPassword) {
		return passwordEcorder.matches(rawPassword, encodedPassword);
	}
}
