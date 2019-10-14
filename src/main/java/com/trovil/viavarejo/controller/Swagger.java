package com.trovil.viavarejo.controller;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.trovil.viavarejo.controller")
public class Swagger {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error"))).build().apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {

		return new ApiInfo("Teste Via-Varejo", "Prova de admissão", "1.0", null,
				new Contact("Megale", "https://www.viavarejo.com.br/", "leandrotrovilho@gmail.vom"), null, null,
				Collections.emptyList());

	}
}