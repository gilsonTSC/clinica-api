package com.gilsontsc.clinica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilsontsc.clinica.api.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}