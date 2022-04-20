package com.dh.clinica.service;

import com.dh.clinica.exception.ResourceNotFoundException;
import com.dh.clinica.model.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    TurnoDTO buscarPorId(Long id);
    Set<TurnoDTO> buscarTodos();
    void eliminarTurno(Long id) throws ResourceNotFoundException;
    TurnoDTO actualizarTurno(TurnoDTO turnoDTO);
    TurnoDTO agregarTurno(TurnoDTO turnoDTO);
}
