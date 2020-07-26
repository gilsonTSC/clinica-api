package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gilsontsc.clinica.api.dto.MedicoDTO;
import com.gilsontsc.clinica.api.entity.Medico;
import com.gilsontsc.clinica.api.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	public Medico salvar(Medico medico) {
		return this.repository.save(medico);
	}
	
	public Optional<Medico> buscarPorId(Long id){
		return this.repository.findById(id);
	}
	
	public Optional<Medico> buscarPorNome(String nome){
		return this.repository.findByNome(nome);
	}
	
	public Optional<Medico> buscarPorCpf(String cpf){
		return this.repository.findByCpf(cpf);
	}
	
	public List<Medico> buscarTodos(){
		return this.repository.findAll();
	}
	
	public Page<Medico> buscarTodos(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
	public Medico convertDtoToEntity(MedicoDTO dto) {
		return Medico.builder()
					 .id(dto.getId())
					 .nome(dto.getNome())
					 .cpf(dto.getCpf())
					 .especialidade(dto.getEspecialidade())
					 .consultas(dto.getConsultas())
					 .build();
	}
	
	public MedicoDTO convertEntityToDto(Medico medico) {
		return MedicoDTO.builder()
						.id(medico.getId())
						.nome(medico.getNome())
						.cpf(medico.getCpf())
						.especialidade(medico.getEspecialidade())
						.consultas(medico.getConsultas())
						.build();
	}
	
}