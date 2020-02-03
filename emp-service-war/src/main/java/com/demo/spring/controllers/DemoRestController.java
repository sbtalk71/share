package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

	@RequestMapping(path = "/info",method = RequestMethod.GET)
	public String getInfo() {
		return "A Simple REST Service from Spring";
	}
	
	@GetMapping(path = "/greet/{name}")
	public String greet(@PathVariable("name")String name) {
		return "Welcome to REST Service, "+name;
	}
}
