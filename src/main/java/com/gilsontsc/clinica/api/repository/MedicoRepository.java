package com.gilsontsc.clinica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	Optional<Medico> findByNome(String nome);
	
	Optional<Medico> findByCpf(String cpf);
	
}