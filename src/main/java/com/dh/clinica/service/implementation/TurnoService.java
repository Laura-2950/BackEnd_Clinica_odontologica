package com.dh.clinica.service.implementation;


import com.dh.clinica.exception.ResourceNotFoundException;
import com.dh.clinica.model.dto.TurnoDTO;
import com.dh.clinica.model.entity.Turno;
import com.dh.clinica.repository.ITurnoRepository;
import com.dh.clinica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//chequeado
@Service
public class TurnoService implements ITurnoService {

    private ITurnoRepository repository;
    private ObjectMapper mapper;


    @Autowired
    public void TurnoService(ITurnoRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void TurnoService(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public TurnoDTO buscarPorId(Long id) {
        Optional<Turno> turno = repository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        Set<TurnoDTO> turnoDTO = new HashSet<>();
        for (Turno turno : repository.findAll()) {
            turnoDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTO;
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = repository.findById(id);
        if (turno.isPresent())
        repository.deleteById(id);
        else throw new ResourceNotFoundException("Odontólogo con id: "+id+", no encontrado.");
    }

    @Override
    public TurnoDTO actualizarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return mapper.convertValue(repository.save(turno), TurnoDTO.class);
    }

    @Override
    public TurnoDTO agregarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return mapper.convertValue(repository.save(turno), TurnoDTO.class);
    }
}
