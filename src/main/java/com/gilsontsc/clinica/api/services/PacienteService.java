package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilsontsc.clinica.api.entity.Paciente;
import com.gilsontsc.clinica.api.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
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
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
}