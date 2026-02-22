package com.sahil.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sahil.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQJsonProducer {

	@Value("${rabbitmq.json.routing.key}")
	private String jsonRoutingKey;
	
	@Value("${rabbitmq.exchange.name}")
	private String exhange;
	
	private RabbitTemplate rabbitTemplate;

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendJsonMessage(User user) {
		log.info(String.format("Json Message Sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exhange, jsonRoutingKey, user);
	}
	
}
