package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
}