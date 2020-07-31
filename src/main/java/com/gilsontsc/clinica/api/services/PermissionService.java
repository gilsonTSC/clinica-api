package com.gilsontsc.clinica.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilsontsc.clinica.api.dto.PermissionDTO;
import com.gilsontsc.clinica.api.entity.Permission;
import com.gilsontsc.clinica.api.repository.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository repository;

	public Permission salvar(Permission permission) {
		return this.repository.save(permission);
	}
	
	public Optional<Permission> buscarPorId(Long id){
		return this.repository.findById(id);
	}
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
	public Permission convertDtoToEntity(PermissionDTO dto) {
		return Permission.builder()
					     .id(dto.getId())
					     .descricao(dto.getDescricao())
					     .build();
	}
	
	public PermissionDTO convertEntityToDto(Permission permission) {
		return PermissionDTO.builder()
							.id(permission.getId())
						    .descricao(permission.getDescricao())
						    .build();
	}
	
}