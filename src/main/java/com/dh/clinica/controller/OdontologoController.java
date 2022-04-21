package com.dh.clinica.controller;


import com.dh.clinica.exception.ResourceNotFoundException;
import com.dh.clinica.model.dto.OdontologoDTO;
import com.dh.clinica.service.implementation.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins="*")
public class OdontologoController {

    private OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }


    @PostMapping()
    public ResponseEntity<OdontologoDTO> registrarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return ResponseEntity.ok(odontologoService.agregarOdontologo(odontologoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Long id) {
        OdontologoDTO odontologoDTO = odontologoService.buscarPorId(id);
        return ResponseEntity.ok(odontologoDTO);
    }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody OdontologoDTO odontologoDTO) {
        ResponseEntity<OdontologoDTO> response = null;

        if (odontologoDTO.getId() != null && odontologoService.buscarPorId(odontologoDTO.getId()) != null)
            response = ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {

            odontologoService.eliminarOdontologo(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontólogo eliminado correctamente");
    }
    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

}
