package com.example.demo.rabbitmq.model;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderTwo {

	@Autowired
	AmqpTemplate rabbitTemplate;
	
	public void send(String msg) {
		String sendMsg = msg + " [ " + new Date() + " ] ";
		System.out.println("SenderTwo : " + sendMsg);
		this.rabbitTemplate.convertAndSend("hello", sendMsg);
	}
}
