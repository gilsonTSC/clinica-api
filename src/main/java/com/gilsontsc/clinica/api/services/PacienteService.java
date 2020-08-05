package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gilsontsc.clinica.api.dto.PacienteDTO;
import com.gilsontsc.clinica.api.entity.Paciente;
import com.gilsontsc.clinica.api.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Transactional
	public Paciente salvar(Paciente paciente) {
		return this.repository.save(paciente);
	}
	
	public Optional<Paciente> buscarPorId(Long id){
		return this.repository.findById(id);
	}
	
	public Optional<Paciente> buscarPorNome(String nome){
		return this.repository.findByNome(nome);
	}
	
	public Optional<Paciente> buscarPorCpf(String cpf){
		return this.repository.findByCpf(cpf);
	}
	
	public List<Paciente> buscarTodos(){
		return this.repository.findAll();
	}
	
	public Page<Paciente> buscarTodos(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	@Transactional
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
	public Paciente convertDtoToEntity(PacienteDTO dto) {
		return Paciente.builder()
					   .id(dto.getId())
					   .nome(dto.getNome())
					   .cpf(dto.getCpf())
					   .consultas(dto.getConsultas())
					   .build();
	}
	
	public PacienteDTO convertEntityToDto(Paciente paciente) {
		return PacienteDTO.builder()
						  .id(paciente.getId())
						  .nome(paciente.getNome())
						  .cpf(paciente.getCpf())
						  .consultas(paciente.getConsultas())
						  .build();
	}
	
}