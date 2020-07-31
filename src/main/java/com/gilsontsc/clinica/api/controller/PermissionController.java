package com.gilsontsc.clinica.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsontsc.clinica.api.controller.exception.ObjectNotFoundException;
import com.gilsontsc.clinica.api.dto.PermissionDTO;
import com.gilsontsc.clinica.api.entity.Permission;
import com.gilsontsc.clinica.api.services.PermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Permission Endpoint", description = "Controler da entidade permission", tags = {"PermissionEndpoint"})
@RestController
@RequestMapping(value="/api/permission")
public class PermissionController {

	@Autowired
	private PermissionService service;
	
	@ApiOperation(value = "Salvar o Permissão")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
				 consumes = { "application/json", "application/xml", "application/x-yaml" })
	@ResponseStatus(HttpStatus.CREATED)
	public PermissionDTO salvar(@RequestBody @Valid PermissionDTO permission) {
		Permission m = this.service.convertDtoToEntity(permission);
		m = this.service.salvar(m);
		return this.service.convertEntityToDto(m);
	}
	
	@ApiOperation(value = "Atualizar o Permissão")
	@PutMapping(value = "{id}", produces = { "application/json", "application/xml", "application/x-yaml" }, 
								consumes = { "application/json", "application/xml", "application/x-yaml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid PermissionDTO permissionAtualizado) {
		this.service.buscarPorId(id)
			.map( permission -> {
				this.service.salvar(this.service.convertDtoToEntity(permissionAtualizado));
				return Void.TYPE;
			})
			.orElseThrow(() -> new ObjectNotFoundException(
					"Médico não encontrado! Id: " + id + ", Tipo: " + Permission.class.getName()));
	}
	
	@ApiOperation(value = "Buscar Permissão pelo Id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PermissionDTO buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id)
				   .map(permission -> {
					   return this.service.convertEntityToDto(permission);
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Médico não encontrado! Id: " + id + ", Tipo: " + Permission.class.getName()));
	}
	
	@ApiOperation(value = "Deletar o Permissão")
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		this.service.buscarPorId(id)
			.map( permission -> {
				this.service.deletar(permission.getId());
				return Void.TYPE;
			})
			.orElseThrow(() -> new ObjectNotFoundException(
					"Médico não encontrado! Id: " + id + ", Tipo: " + Permission.class.getName()));
	}
	
}