package com.gilsontsc.clinica.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_consulta")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "medico_id")
	private Long medico;
	
	@Column(name = "paciente_id")
	private Long paciente;
	
	@Column(name = "procedimento_id")
	private Long procedimento;
	
	@Column(name = "data_atendimento")
	private Date dataAtendimento;
	
}