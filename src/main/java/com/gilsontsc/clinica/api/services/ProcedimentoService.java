package com.gilsontsc.clinica.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void deletar(Long id){
		this.repository.deleteById(id);
	}
	
}