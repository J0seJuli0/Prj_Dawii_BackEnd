package com.permisos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.permisos.model.entity.TipoDocumento;
import com.permisos.model.repository.ITipoDocumentoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tipoDocumento")
@AllArgsConstructor
public class TipoDocumentoController {

	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	@GetMapping("/listar")
	public List<TipoDocumento> lista(){
		return tipoDocumentoRepository.findAll();
	}
}
