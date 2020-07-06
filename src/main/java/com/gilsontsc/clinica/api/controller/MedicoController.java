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
import org.springframework.web.server.ResponseStatusException;

import com.gilsontsc.clinica.api.dto.ConsultaDTO;
import com.gilsontsc.clinica.api.dto.MedicoDTO;
import com.gilsontsc.clinica.api.dto.ProcedimentoDTO;
import com.gilsontsc.clinica.api.entity.Medico;
import com.gilsontsc.clinica.api.services.ConsultaService;
import com.gilsontsc.clinica.api.services.MedicoService;
import com.gilsontsc.clinica.api.services.ProcedimentoService;

@RestController
@RequestMapping(value="/api/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MedicoDTO salvar(@RequestBody @Valid MedicoDTO medico) {
		Medico m = this.medicoService.convertDtoToEntity(medico);
		m = this.medicoService.salvar(m);
		return this.medicoService.convertEntityToDto(m);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid MedicoDTO medicoAtualizado) {
		this.medicoService.buscarPorId(id)
			.map( medico -> {
				this.medicoService.salvar(this.medicoService.convertDtoToEntity(medicoAtualizado));
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));
	}
	
	@GetMapping
	public List<MedicoDTO> obterTodos(){
		List<MedicoDTO> list = new ArrayList<>();
		this.medicoService.buscarTodos()
			.forEach(medico -> {
				list.add(this.medicoService.convertEntityToDto(medico));
			});
		return list;
	}
	
	@GetMapping("{id}")
	public MedicoDTO buscarPorId(@PathVariable Long id) {
		return this.medicoService.buscarPorId(id)
				   .map(medico -> {
					   return this.medicoService.convertEntityToDto(medico);
				   })
				   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		this.medicoService.buscarPorId(id)
			.map( medico -> {
				this.medicoService.deletar(medico.getId());
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));
	}
	
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
				   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidades não encontradas"));
	}
	
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
				   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consultas não encontradas"));
	}
	
}