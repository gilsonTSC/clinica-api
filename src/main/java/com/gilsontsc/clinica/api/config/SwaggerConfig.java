package com.gilsontsc.clinica.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gilsontsc.clinica"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"RESTful API Spring Boot 2.2.8", 
				"Clinica G&G" , 
				"V1", 
				"Gratuito", 
				new Contact("Gilson Trajano", "https://www.linkedin.com/in/gilson-trajano-b01ab28a/", "gilson.trajano@gmail.com"), 
				"Licença API", "Licença URI", Collections.emptyList());
	}
	
}