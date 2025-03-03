package com.example.restful_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static int healthCheckedTimes = 0;
    
    @GetMapping("/")
	public String home() {
		return String.format("RESTful API Springboot project template.");
	}

	@GetMapping("/health")
	public String health() {
		return String.format("The application is running properly. Times checked: %d", ++healthCheckedTimes);
	}
}
