package com.sahil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.dto.User;
import com.sahil.publisher.RabbitMQJsonProducer;

@RestController
public class JsonMessageController {

	private final RabbitMQJsonProducer jsonProducer;

	public JsonMessageController(RabbitMQJsonProducer jsonProducer) {
		this.jsonProducer = jsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user) {
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json message sent to RabbitMQ...");
	}
}
