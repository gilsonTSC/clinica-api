package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gilsontsc.clinica.api.dto.ProcedimentoDTO;
import com.gilsontsc.clinica.api.entity.Procedimento;
import com.gilsontsc.clinica.api.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository repository;
	
	public Procedimento salvar(Procedimento procedimento) {
		return this.repository.save(procedimento);
	}
	
	public Optional<Procedimento> buscarPorId(Long id) {
		return this.repository.findById(id);
	}
	
	public Optional<Procedimento> buscarPorNome(String nome) {
		return this.repository.findByNome(nome);
	}
	
	public List<Procedimento> buscarTodos(){
		return this.repository.findAll();
	}
	
	public Page<Procedimento> buscarTodos(Pageable pageable) {
		return this.repository.findAll(pageable);
	}
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
	public Procedimento convertDtoToEntity(ProcedimentoDTO dto) {
		return Procedimento.builder()
						   .id(dto.getId())
						   .nome(dto.getNome())
						   .descricao(dto.getDescricao())
						   .preco(dto.getPreco())
						   .medico(dto.getMedico())
						   .consulta(dto.getConsulta())
						   .build();
	}
	
	public ProcedimentoDTO convertEntityToDto(Procedimento procedimento) {
		return ProcedimentoDTO.builder()
						      .id(procedimento.getId())
						      .nome(procedimento.getNome())
						      .descricao(procedimento.getDescricao())
						      .preco(procedimento.getPreco())
						      .medico(procedimento.getMedico())
							  .consulta(procedimento.getConsulta())
						      .build();
	}
	
}