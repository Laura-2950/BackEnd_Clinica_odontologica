package com.dh.clinica.service.implementation;

import com.dh.clinica.model.dto.DomicilioDTO;
import com.dh.clinica.model.dto.PacienteDTO;
import com.dh.clinica.entity.Domicilio;
import com.dh.clinica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class PacienteServiceTest {


    private IPacienteService pacienteService;
    private ObjectMapper mapper;
    @Autowired
    public PacienteServiceTest(IPacienteService pacienteService,ObjectMapper mapper){
        this.pacienteService= pacienteService;
        this.mapper= mapper;
    }

    @Test
    void agregarYBuscarPorIdUnPaciente() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();
        domicilioDTO.setNumero("2982");
        domicilioDTO.setProvincia("Buenos Aires");
        domicilioDTO.setLocalidad("Lujan");
        domicilioDTO.setCalle("Julio A. Roca");

        PacienteDTO pacienteDTO= new PacienteDTO();
        pacienteDTO.setApellido("Perez");
        pacienteDTO.setDni("30.568.991");
        pacienteDTO.setDomicilio(mapper.convertValue(domicilioDTO,Domicilio.class));
        pacienteDTO.setFechaIngreso(new Date(2022, 03, 01));
        pacienteDTO.setNombre("Valentino");

        PacienteDTO pacienteDTO1=pacienteService.agregarPaciente(pacienteDTO);

        assertTrue(pacienteService.buscarPorId(pacienteDTO1.getId()) != null);
    }

    @Test
    void modificarUnPaciente() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();
        domicilioDTO.setNumero("2982");
        domicilioDTO.setProvincia("Neuquen");
        domicilioDTO.setLocalidad("San Martín de los Andes");
        domicilioDTO.setCalle("9 de Julio");

        PacienteDTO pacienteDTO= new PacienteDTO();
        pacienteDTO.setApellido("Ramirez");
        pacienteDTO.setDni("45.568.991");
        pacienteDTO.setDomicilio(mapper.convertValue(domicilioDTO,Domicilio.class));
        pacienteDTO.setFechaIngreso(new Date(2022, 03, 01));
        pacienteDTO.setNombre("Martin");
        pacienteService.agregarPaciente(pacienteDTO);
        PacienteDTO pacienteDTO1=pacienteService.actualizarPaciente(pacienteDTO);
        pacienteDTO1.setNombre("Carlos");

        assertTrue(pacienteDTO1.getNombre() == "Carlos");
    }

    @Test
    void buscarTodos() {
        Set<PacienteDTO> listadoPacientes= pacienteService.buscarTodos();

        assertTrue(listadoPacientes.size() != 0);
    }

    @Test
    void eliminarPaciente() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();
        domicilioDTO.setNumero("1005");
        domicilioDTO.setProvincia("La Pampa");
        domicilioDTO.setLocalidad("General Pico");
        domicilioDTO.setCalle("Combate San Lorenzo");

        PacienteDTO pacienteDTO= new PacienteDTO();
        pacienteDTO.setApellido("Fernandez");
        pacienteDTO.setDni("31.532.991");
        pacienteDTO.setDomicilio(mapper.convertValue(domicilioDTO, Domicilio.class));
        pacienteDTO.setFechaIngreso(new Date(2022, 04, 10));
        pacienteDTO.setNombre("Agustina");

        PacienteDTO pacienteDTO1=pacienteService.agregarPaciente(pacienteDTO);
        pacienteService.eliminarPaciente(pacienteDTO1.getId());

        assertTrue(pacienteService.buscarPorId(pacienteDTO1.getId()) == null);
    }


}