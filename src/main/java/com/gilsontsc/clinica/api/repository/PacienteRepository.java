package com.gilsontsc.clinica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}