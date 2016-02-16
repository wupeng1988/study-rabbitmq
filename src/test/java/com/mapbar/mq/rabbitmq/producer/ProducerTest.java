package com.mapbar.mq.rabbitmq.producer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.mapbar.mq.rabbitmq.common.SimpleModel;

//@ContextConfiguration(locations={"classpath:application-producer.xml"})
//@ContextConfiguration(locations={"classpath:application-producer2.xml"})
@ContextConfiguration(locations={"classpath:application-producer3.xml"})
public class ProducerTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	MessageProducer sender;
	
	@Test
	public void testSend() throws InterruptedException{
		Random rand = new Random();
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			SimpleModel model = new SimpleModel(String.valueOf(rand.nextInt()), System.currentTimeMillis()+""); 
			sender.sendMessage(model);
			model.setId(String.valueOf(rand.nextInt()));
			sender.sendMessage2(model);
			System.out.println("send message ok !");
			TimeUnit.MILLISECONDS.sleep(500);
		}
		System.out.println("cost time : " + (System.currentTimeMillis() - start));
		System.out.println("ok");
	}
	
}
