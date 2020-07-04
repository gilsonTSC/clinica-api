package com.gilsontsc.clinica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Optional<Paciente> findByNome(String nome);

	Optional<Paciente> findByCpf(String cpf);

}