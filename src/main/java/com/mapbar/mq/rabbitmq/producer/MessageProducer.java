package com.mapbar.mq.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageProducer {
	@Autowired
	private RabbitTemplate amqpTemplate;
	@Autowired
	private RabbitTemplate amqpTemplate2;

	public void sendMessage2(Object obj){
		amqpTemplate2.convertAndSend(obj);
	}
	
	public void sendMessage(Object obj) {
		amqpTemplate.convertAndSend(obj);
	}

	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.amqpTemplate = rabbitTemplate;
	}

}
