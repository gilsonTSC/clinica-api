package com.gilsontsc.clinica.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gilsontsc.clinica.api.entity.Medico;
import com.gilsontsc.clinica.api.entity.Paciente;
import com.gilsontsc.clinica.api.entity.Procedimento;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaDTO {

	private Long id;
	
	@NotNull(message = "Informe o Médico")
	private Medico medico;
	
	@NotNull(message = "Informe o Paciente")
	private Paciente paciente;
	
	@NotNull(message = "Informe o procedimento")
	private Procedimento procedimento;
	
	@NotNull(message = "Informe a data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataAtendimento;
	
}