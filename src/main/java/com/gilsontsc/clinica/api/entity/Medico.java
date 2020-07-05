package com.gilsontsc.clinica.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_medico")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;
	
	@JsonIgnore
	@OneToMany(mappedBy="medico")
	private List<Procedimento> especialidade;
	
	@JsonIgnore
	@OneToMany(mappedBy="medico")
	private List<Consulta> consultas;
	
}