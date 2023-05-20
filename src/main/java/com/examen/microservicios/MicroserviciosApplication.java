package com.examen.microservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Hiram Yadzael Vargas Chalico
 * https://github.com/yadzael13
 * Práctica Microservicios
 * Mayo del 2023
 * Version: 1.0
 * ---SWAGGER
 * http://localhost:8080/swagger-ui/index.html#/
 */
@SpringBootApplication
public class MicroserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosApplication.class, args);
		System.out.println("\n** ---------------- APLICATION CORRECTLY INITIALIZED ----------------- **\n");
	}

}
