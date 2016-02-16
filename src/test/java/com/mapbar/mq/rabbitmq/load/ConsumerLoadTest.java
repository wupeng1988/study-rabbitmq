package com.mapbar.mq.rabbitmq.load;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerLoadTest {
	
	public static void main(String[] args) {
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer.xml"});
//		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer2.xml"});
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"application-consumer-load.xml"});
	}
	
}
