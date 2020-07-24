package com.gilsontsc.clinica.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "tb_permission")
@Builder
@Data
public class Permission implements GrantedAuthority, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String descricao;
	
	@Override
	public String getAuthority() {
		return this.descricao;
	}

}