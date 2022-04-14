package com.dh.clinica.model.dto;

import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.entity.Paciente;
import lombok.Getter;

import java.util.Date;

//chequeado
@Getter
public class TurnoDTO {

    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date fechaIngreso;

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
