package com.conversor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conversor.controller.MenuController;

@SpringBootApplication
public class ConversorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorApplication.class, args);
		 new MenuController().iniciar();
	}

}
