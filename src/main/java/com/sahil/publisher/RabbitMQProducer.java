package com.sahil.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	private RabbitTemplate rabbitTemplate;
	
	private Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(String message) {
		logger.info(String.format("Message sent -> %s", message));
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
	
}
