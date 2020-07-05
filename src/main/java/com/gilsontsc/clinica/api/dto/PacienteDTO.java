package com.gilsontsc.clinica.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gilsontsc.clinica.api.entity.Consulta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PacienteDTO {

	private Long id;
	
	@NotNull(message = "O nome não pode ficar em branco")
	@Length(min=3, max=50, message="O nome deve conter entre 3 a 50 caracteres")
	private String nome;
	
	@NotNull(message = "O CPF não pode ficar em branco")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	private List<Consulta> consultas;
	
}