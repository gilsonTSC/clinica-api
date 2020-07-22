package com.gilsontsc.clinica.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaDTO {

	private Long id;
	
	@NotNull(message = "Informe o Médico")
	private Long medico;
	
	@NotNull(message = "Informe o Paciente")
	private Long paciente;
	
	@NotNull(message = "Informe o procedimento")
	private Long procedimento;
	
	@NotNull(message = "Informe a data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataAtendimento;
	
}