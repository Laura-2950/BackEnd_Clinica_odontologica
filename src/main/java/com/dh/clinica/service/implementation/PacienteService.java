package com.dh.clinica.service.implementation;

import com.dh.clinica.entity.Paciente;
import com.dh.clinica.model.dto.PacienteDTO;
import com.dh.clinica.repository.jpa.IPacienteRepository;
import com.dh.clinica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//chequeado
@Service
public class PacienteService implements IPacienteService {

    private IPacienteRepository repository;
    private ObjectMapper mapper;




    @Autowired
    public void PacienteService(IPacienteRepository repository,ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public PacienteDTO buscarPorId(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        Set<PacienteDTO> pacienteDTO = new HashSet<>();
        for(Paciente paciente : repository.findAll()) {
            pacienteDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTO;
    }

    @Override
    public void eliminarPaciente(Long id) {
        repository.deleteById(id);
    }


    @Override
    public PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return mapper.convertValue(repository.save(paciente), PacienteDTO.class);
    }

    //ANDA
    @Override
    public PacienteDTO agregarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return mapper.convertValue(repository.save(paciente), PacienteDTO.class);
    }
}