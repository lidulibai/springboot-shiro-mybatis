package com.example.demo.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rabbitmq.model.SenderOne;
import com.example.demo.rabbitmq.model.SenderTwo;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

	@Autowired
	private SenderOne senderOne;
	
	@Autowired
	private SenderTwo senderTwo;
	
	@GetMapping("/hello")
	public void hello() {
//		senderOne.send();
	}
	
	@GetMapping("/oneToMany")
	public void oneToMany() {
		for(int i = 0; i < 10; i++) {
			senderOne.send("hellomsg: " + i);
			senderTwo.send("hellomsg: " + i);
		}
	}
}
