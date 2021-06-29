package com.te.student.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class StudentBootController {
	@GetMapping("/")
	public String firstHandlerMethod() {
		return "TechnoElevatr";
	}

}
