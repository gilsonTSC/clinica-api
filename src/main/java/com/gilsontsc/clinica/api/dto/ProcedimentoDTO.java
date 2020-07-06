package com.gilsontsc.clinica.api.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gilsontsc.clinica.api.entity.Consulta;
import com.gilsontsc.clinica.api.entity.Medico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProcedimentoDTO {

	private Long id;
	
	private Medico medico;
	
	private Consulta consulta;
	
	@NotNull(message = "Informe o nome do procedimento")
	@Length(min=3, max=50, message="O nome deve conter entre 3 a 50 caracteres")
	private String nome;
	
	private String descricao;
	
	@NotNull(message = "Informe o valor do procedimento")
	private Double preco;
	
}