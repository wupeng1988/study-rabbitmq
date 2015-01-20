package com.mapbar.mq.rabbitmq.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
	
	public static void main(String[] args) {
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer.xml"});
//		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer2.xml"});
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer3.xml"});
	}
	
}
