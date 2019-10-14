package com.trovil.viavarejo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootViaVarejoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootViaVarejoApplication.class, args);
	}

}
