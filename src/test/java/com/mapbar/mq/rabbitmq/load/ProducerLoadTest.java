package com.mapbar.mq.rabbitmq.load;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.mapbar.mq.rabbitmq.common.SimpleModel;
import com.mapbar.mq.rabbitmq.producer.MessageProducer;

//@ContextConfiguration(locations={"classpath:application-producer.xml"})
//@ContextConfiguration(locations={"classpath:application-producer2.xml"})
@ContextConfiguration(locations={"classpath:application-producer-load.xml"})
public class ProducerLoadTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	MessageProducer sender;
	
	final AtomicInteger atomicInteger = new AtomicInteger(0);
	
	/**
	 * 
	 *
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testSend() throws InterruptedException{
		Random rand = new Random();
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++){
			SimpleModel model = new SimpleModel(String.valueOf(rand.nextInt()), System.currentTimeMillis()+""); 
			sender.sendMessage(model);
			model.setId(String.valueOf(rand.nextInt()));
			sender.sendMessage2(model);
		}
		System.out.println("cost time : " + (System.currentTimeMillis() - start));
		System.out.println("ok");
	}
	
	/**
	 * 
	 * 启动10个线程， 共发2千万
	 * @throws InterruptedException 
	 * 
	 * 
	 */
//	@Test
	public void testSend2() throws InterruptedException{
		final Random rand = new Random();
		long start = System.currentTimeMillis();
		final CountDownLatch latch = new CountDownLatch(10);
		
		for(int i = 0; i < 10; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(atomicInteger.get() < 10000000) {
						SimpleModel model = new SimpleModel(String.valueOf(rand.nextInt()), System.currentTimeMillis()+""); 
						sender.sendMessage(model);
						model.setId(String.valueOf(rand.nextInt()));
						sender.sendMessage2(model);
						atomicInteger.incrementAndGet();
					}
					latch.countDown();
				}
			}).start();
		}
		
		System.out.println("thread startup success, I am waiting...");
		latch.await();
		System.out.println("cost time : " + (System.currentTimeMillis() - start));
		System.out.println("ok");
	}
	
}
