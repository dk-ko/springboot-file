package com.example.filedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class WebRestController {
	
	@GetMapping("/testz")
	public String hello() {
		return "HelloWorld !!";
	}
	
}