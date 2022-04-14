package com.dh.clinica.controller;

import com.dh.clinica.model.dto.TurnoDTO;
import com.dh.clinica.service.implementation.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//chequeado
@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins="http://localhost:3000")
public class TurnoController {

    private TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService){
        this.turnoService = turnoService;
    }


    @PostMapping()
    public ResponseEntity<TurnoDTO> registrarOdontologo(@RequestBody TurnoDTO turnoDTO) {
        return ResponseEntity.ok(turnoService.agregarTurno(turnoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Long id) {
        TurnoDTO turnoDTO = turnoService.buscarPorId(id);
        return ResponseEntity.ok(turnoDTO);
    }

    @PutMapping()
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turnoDTO) {
        ResponseEntity<TurnoDTO> response = null;

        if (turnoDTO.getId() != null && turnoService.buscarPorId(turnoDTO.getId()) != null)
            response = ResponseEntity.ok(turnoService.actualizarTurno(turnoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (turnoService.buscarPorId(id) != null) {
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

}
