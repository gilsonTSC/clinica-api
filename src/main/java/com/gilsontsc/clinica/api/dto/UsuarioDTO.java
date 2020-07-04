package com.gilsontsc.clinica.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

	private Long id;
	
	@Email(message="Email inválido")
	private String email;
	
	@NotNull(message = "O nome não pode ficar em branco")
	@Length(min=3, max=50, message="O nome deve conter entre 3 a 50 caracteres")
	private String name;
	
	@NotNull(message = "O senha não pode ficar em branco")
	@Length(min=6, message="A senha deve conter no minimo 6 caracteres")
	private String senha;
	
	@NotNull(message = "Informe uma role de acesso")
	@Pattern(regexp="^(ROLE_MEDICO|ROLE_PACIENTE)$", message = "Para A ROLE DE ACESSO somente são aceitos os valores ROLE_MEDICO ou ROLE_PACIENTE")
	private String role;
	
}