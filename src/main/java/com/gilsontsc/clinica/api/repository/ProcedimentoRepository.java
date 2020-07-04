package com.gilsontsc.clinica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>{

}