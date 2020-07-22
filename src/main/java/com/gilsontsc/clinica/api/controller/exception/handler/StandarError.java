package com.gilsontsc.clinica.api.controller.exception.handler;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandarError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

}