package com.gilsontsc.clinica.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gilsontsc.clinica.api.entity.Consulta;
import com.gilsontsc.clinica.api.entity.Procedimento;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicoDTO {

	private Long id;
	
	@NotNull(message = "Informe o nome do procedimento")
	@Length(min=3, max=50, message="O nome deve conter entre 3 a 50 caracteres")
	private String nome;
	
	@NotNull(message = "O CPF não pode ficar em branco")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	private List<Procedimento> especialidade;
	
	private List<Consulta> consultas;
	
}