package com.gilsontsc.clinica.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsontsc.clinica.api.controller.exception.ObjectNotFoundException;
import com.gilsontsc.clinica.api.dto.ConsultaDTO;
import com.gilsontsc.clinica.api.dto.PacienteDTO;
import com.gilsontsc.clinica.api.entity.Paciente;
import com.gilsontsc.clinica.api.services.ConsultaService;
import com.gilsontsc.clinica.api.services.PacienteService;

@RestController
@RequestMapping(value="/api/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PacienteDTO salvar(@RequestBody @Valid PacienteDTO paciente) {
		Paciente p = this.pacienteService.salvar(this.pacienteService.convertDtoToEntity(paciente));
		return this.pacienteService.convertEntityToDto(p);
	}
	
	@GetMapping
	public List<PacienteDTO> obterTodos(){
		List<PacienteDTO> list = new ArrayList<>();
		this.pacienteService
		    .buscarTodos()
		    .forEach(paciente -> {
			    list.add(this.pacienteService.convertEntityToDto(paciente));
		    });
		return list;
	}
	
	@GetMapping("{id}")
	public PacienteDTO buscarPorId(@PathVariable Long id) {
		return this.pacienteService
				   .buscarPorId(id)
				   .map(paciente -> {
					   return this.pacienteService.convertEntityToDto(paciente);
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Paciente não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		this.pacienteService.buscarPorId(id)
			.map( paciente -> {
				this.pacienteService.deletar(paciente.getId());
				return Void.TYPE;
			})
			.orElseThrow(() -> new ObjectNotFoundException(
					"Paciente não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}
	
	@GetMapping("{id}/consultas")
	public List<ConsultaDTO> listTodasConsulta(@PathVariable Long id) {
		List<ConsultaDTO> list = new ArrayList<>();
		return this.pacienteService.buscarPorId(id)
				   .map(paciente -> {
					   paciente.getConsultas().forEach(consulta -> {
						   list.add(this.consultaService.convertEntityToDto(consulta));
					   });
					   return list;
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Paciente não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}
	
}