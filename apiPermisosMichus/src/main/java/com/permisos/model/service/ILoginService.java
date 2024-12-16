package com.permisos.model.service;

import com.permisos.model.dto.LoginInputDTO;
import com.permisos.model.dto.LoginOutputDTO;

public interface ILoginService {
	LoginOutputDTO login (LoginInputDTO inputDTO);
}
