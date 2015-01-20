package com.mapbar.mq.rabbitmq.consumer;

public class Consumer {

	public void recive(Object obj){
		System.out.println(this.toString()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 1 :"+obj);
	}
	
	public void recive2(Object obj){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 2 :"+obj);
	}

	public void recive3(Object obj){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 3 :"+obj);
	}
	
	public void recive4(Object obj){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 4 :"+obj);
	}
	
}
