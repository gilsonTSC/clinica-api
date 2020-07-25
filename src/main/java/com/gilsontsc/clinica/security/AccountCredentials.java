package com.gilsontsc.clinica.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCredentials implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;

}