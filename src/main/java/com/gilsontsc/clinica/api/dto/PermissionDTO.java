package com.gilsontsc.clinica.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class PermissionDTO {

	private Long id;
	
	@NotNull(message = "A descrição não pode ficar em branco")
	@Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$", message = "Para A ROLE DE ACESSO somente são aceitos os valores ROLE_ADMIN ou ROLE_USER")
	private String descricao;
	
}