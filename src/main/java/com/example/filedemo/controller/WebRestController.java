package com.example.filedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class WebRestController {
	
	@GetMapping("/test")
	public String hello() {
		return "HelloWorld !!";
	}
	
}