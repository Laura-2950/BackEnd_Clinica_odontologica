package com.dh.clinica.service;

import com.dh.clinica.model.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    OdontologoDTO buscarPorId(Long id);
    Set<OdontologoDTO> buscarTodos();
    void eliminarOdontologo(Long id);
    OdontologoDTO actualizarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO agregarOdontologo(OdontologoDTO odontologoDTO);
}