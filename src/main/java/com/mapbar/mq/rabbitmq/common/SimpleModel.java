package com.mapbar.mq.rabbitmq.common;

public class SimpleModel {

	private String id;
	private String name;

	public SimpleModel(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SimpleModel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.id + " -- " + this.name;
	}
	
}
