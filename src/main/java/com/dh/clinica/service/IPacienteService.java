package com.dh.clinica.service;

import com.dh.clinica.model.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    PacienteDTO buscarPorId(Long id);
    Set<PacienteDTO> buscarTodos();
    void eliminarPaciente(Long id);
    PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO agregarPaciente(PacienteDTO pacienteDTO);
}
