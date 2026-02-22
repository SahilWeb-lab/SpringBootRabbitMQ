package com.sahil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.publisher.RabbitMQProducer;

@RestController
public class MessageController {

	private RabbitMQProducer rabbitMQProducer;

	public MessageController(RabbitMQProducer rabbitMQProducer) {
		super();
		this.rabbitMQProducer = rabbitMQProducer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam String message) {
		rabbitMQProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to RabbitMQ....");
	}
}
