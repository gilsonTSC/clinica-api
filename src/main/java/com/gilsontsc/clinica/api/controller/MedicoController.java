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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsontsc.clinica.api.controller.exception.ObjectNotFoundException;
import com.gilsontsc.clinica.api.dto.ConsultaDTO;
import com.gilsontsc.clinica.api.dto.MedicoDTO;
import com.gilsontsc.clinica.api.dto.ProcedimentoDTO;
import com.gilsontsc.clinica.api.entity.Consulta;
import com.gilsontsc.clinica.api.entity.Medico;
import com.gilsontsc.clinica.api.entity.Procedimento;
import com.gilsontsc.clinica.api.services.ConsultaService;
import com.gilsontsc.clinica.api.services.MedicoService;
import com.gilsontsc.clinica.api.services.ProcedimentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Medico Endpoint", description = "Controler da entidade médico", tags = {"MedicoEndpoint"})
@RestController
@RequestMapping(value="/api/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@ApiOperation(value = "Salvar o Médico")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MedicoDTO salvar(@RequestBody @Valid MedicoDTO medico) {
		Medico m = this.medicoService.convertDtoToEntity(medico);
		m = this.medicoService.salvar(m);
		return this.medicoService.convertEntityToDto(m);
	}
	
	@ApiOperation(value = "Atualizar o Médico")
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid MedicoDTO medicoAtualizado) {
		this.medicoService.buscarPorId(id)
			.map( medico -> {
				this.medicoService.salvar(this.medicoService.convertDtoToEntity(medicoAtualizado));
				return Void.TYPE;
			})
			.orElseThrow(() -> new ObjectNotFoundException(
					"Médico não encontrado! Id: " + id + ", Tipo: " + Medico.class.getName()));
	}
	
	@ApiOperation(value = "Lista todos os Médicos")
	@GetMapping
	public List<MedicoDTO> obterTodos(){
		List<MedicoDTO> list = new ArrayList<>();
		this.medicoService.buscarTodos()
			.forEach(medico -> {
				list.add(this.medicoService.convertEntityToDto(medico));
			});
		return list;
	}
	
	@ApiOperation(value = "Buscar Médico pelo Id")
	@GetMapping("{id}")
	public MedicoDTO buscarPorId(@PathVariable Long id) {
		return this.medicoService.buscarPorId(id)
				   .map(medico -> {
					   return this.medicoService.convertEntityToDto(medico);
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Médico não encontrado! Id: " + id + ", Tipo: " + Medico.class.getName()));
	}
	
	@ApiOperation(value = "Deletar o Médico")
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		this.medicoService.buscarPorId(id)
			.map( medico -> {
				this.medicoService.deletar(medico.getId());
				return Void.TYPE;
			})
			.orElseThrow(() -> new ObjectNotFoundException(
					"Médico não encontrado! Id: " + id + ", Tipo: " + Medico.class.getName()));
	}
	
	@ApiOperation(value = "Lista todos as especialidades do Médico")
	@GetMapping("{id}/especialidades")
	public List<ProcedimentoDTO> listTodasEspecialidades(@PathVariable Long id) {
		List<ProcedimentoDTO> list = new ArrayList<>();
		return this.medicoService.buscarPorId(id)
				   .map(medico -> {
					   medico.getEspecialidade().forEach(procedimento -> {
						   list.add(this.procedimentoService.convertEntityToDto(procedimento));
					   });
					   return list;
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Especialidade não encontrada! Id: " + id + ", Tipo: " + Procedimento.class.getName()));
	}
	
	@ApiOperation(value = "Lista todas as consultas do Médico")
	@GetMapping("{id}/consultas")
	public List<ConsultaDTO> listTodasConsultas(@PathVariable Long id) {
		List<ConsultaDTO> list = new ArrayList<>();
		return this.medicoService.buscarPorId(id)
				   .map(medico -> {
					   medico.getConsultas().forEach(consulta -> {
						   list.add(this.consultaService.convertEntityToDto(consulta));
					   });
					   return list;
				   })
				   .orElseThrow(() -> new ObjectNotFoundException(
							"Consulta não encontrada! Id: " + id + ", Tipo: " + Consulta.class.getName()));
	}
	
}