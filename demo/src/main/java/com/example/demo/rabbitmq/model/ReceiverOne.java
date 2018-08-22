package com.example.demo.rabbitmq.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class ReceiverOne {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("ReceiverOne : " + hello);
	}
}
