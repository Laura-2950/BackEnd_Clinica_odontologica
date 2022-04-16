package com.dh.clinica.repository;

import com.dh.clinica.model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//chequeado
@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
