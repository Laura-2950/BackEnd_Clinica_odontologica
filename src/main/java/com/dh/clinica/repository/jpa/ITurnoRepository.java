package com.dh.clinica.repository.jpa;

import com.dh.clinica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//chequeado
@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
