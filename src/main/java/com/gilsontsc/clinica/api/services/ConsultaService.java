package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilsontsc.clinica.api.dto.ConsultaDTO;
import com.gilsontsc.clinica.api.entity.Consulta;
import com.gilsontsc.clinica.api.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;
	
	public Consulta salvar(Consulta Consulta) {
		return this.repository.save(Consulta);
	}
	
	public Optional<Consulta> buscarPorId(Long id){
		return this.repository.findById(id);
	}
	
	public List<Consulta> buscarTodos(){
		return this.repository.findAll();
	}
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
	public Consulta convertDtoToEntity(ConsultaDTO dto) {
		return Consulta.builder()
					   .id(dto.getId())
					   .medico(dto.getMedico())
					   .paciente(dto.getPaciente())
					   .procedimento(dto.getProcedimento())
					   .dataAtendimento(dto.getDataAtendimento())
					   .build();
	}
	
	public ConsultaDTO convertEntityToDto(Consulta consulta) {
		return ConsultaDTO.builder()
						  .id(consulta.getId())
						  .medico(consulta.getMedico())
						  .paciente(consulta.getPaciente())
						  .procedimento(consulta.getProcedimento())
						  .dataAtendimento(consulta.getDataAtendimento())
						  .build();
	}
	
}