package com.dh.clinica.repository;



import com.dh.clinica.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//chequeado
@Repository
public interface IPacienteRepository extends JpaRepository <Paciente, Long>{
}
