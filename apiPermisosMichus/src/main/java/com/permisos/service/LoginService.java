package com.permisos.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.permisos.model.repository.ILoginRepository;

import lombok.AllArgsConstructor;

@Service
public class LoginService {

	private final ILoginRepository loginRepository;
	
	public LoginService(ILoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	public Map<String, Object> login(String email, String contrasenia) {
		return loginRepository.login(email, contrasenia);
	}
}
