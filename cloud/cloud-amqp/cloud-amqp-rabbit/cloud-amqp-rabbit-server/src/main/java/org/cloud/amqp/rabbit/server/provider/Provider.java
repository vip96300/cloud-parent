package org.cloud.amqp.rabbit.server.provider;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Provider {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(){
		String message=this.getClass().getName()+" in "+new Date().getTime()+" sended message!";
		System.out.println(message);
		this.amqpTemplate.convertAndSend("queues-application",message);
	}
}
