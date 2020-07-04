package com.gilsontsc.clinica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}