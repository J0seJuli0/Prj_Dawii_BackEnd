package com.permisos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.permisos.model.entity.TipoDocumento;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

}
