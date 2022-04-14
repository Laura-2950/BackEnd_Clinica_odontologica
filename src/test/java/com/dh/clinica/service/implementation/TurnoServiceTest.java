package com.dh.clinica.service.implementation;

import com.dh.clinica.service.IDomicilioService;
import com.dh.clinica.service.IOdontologoService;
import com.dh.clinica.service.IPacienteService;
import com.dh.clinica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TurnoServiceTest {

    private ITurnoService turnoService;
    private IPacienteService pacienteService;
    private IDomicilioService domicilioService;
    private IOdontologoService odontologoService;
    private ObjectMapper mapper;
    @Autowired
    public TurnoServiceTest(IPacienteService pacienteService, IDomicilioService domicilioService, ObjectMapper mapper){
        this.pacienteService= pacienteService;
        this.domicilioService= domicilioService;
        this.mapper=mapper;
    }

    @Test
    void turnoService() {
    }

    @Test
    void testTurnoService() {
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void buscarTodos() {
    }

    @Test
    void eliminarTurno() {
    }

    @Test
    void actualizarTurno() {
    }

    @Test
    void agregarTurno() {
    }
}