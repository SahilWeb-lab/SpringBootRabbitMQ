package com.sahil.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.sahil.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

	@RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
	public void JsonMessageConsumer(User user) {
		log.info(String.format("Received JSON Message -> %s", user));
	}
	
}
