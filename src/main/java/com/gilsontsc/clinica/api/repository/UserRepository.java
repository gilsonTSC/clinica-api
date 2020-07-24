package com.gilsontsc.clinica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}