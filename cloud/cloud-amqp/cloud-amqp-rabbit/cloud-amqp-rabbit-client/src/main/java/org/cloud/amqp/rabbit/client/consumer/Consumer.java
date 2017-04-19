package org.cloud.amqp.rabbit.client.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="queues-application")
public class Consumer {
	
	@RabbitHandler
	public void process(String message){
		System.out.println(message);
	}
}
