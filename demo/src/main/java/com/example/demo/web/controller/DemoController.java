package com.example.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String demo() {
		return "demo";
	}
}
