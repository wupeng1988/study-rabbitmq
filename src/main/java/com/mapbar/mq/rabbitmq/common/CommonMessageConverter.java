package com.mapbar.mq.rabbitmq.common;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CommonMessageConverter implements MessageConverter {

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		byte[] bytes = message.getBody();
		if(bytes != null && bytes.length > 0){
			try {
				String json = new String(bytes, "UTF-8");
				return JsonUtil.fromJson(json, SimpleModel.class);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Message toMessage(Object obj, MessageProperties props) throws MessageConversionException {
		byte[] bytes = new byte[1];
		try {
			String text = JsonUtil.toJson(obj);
			bytes = text.getBytes("UTF-8");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new Message(bytes, props);
	}

}
