package com.dh.clinica.repository.jpa;

import com.dh.clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//chequeado
@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {


}