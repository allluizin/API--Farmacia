package com.remedios.luiz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //dizer que vai ser um controle
@RequestMapping("/hello") //vai ser acessado por esse link
public class HelloWorldController {
	
	@GetMapping
	public String olamundo() {
		return "hELLO wORLD";
	}
}