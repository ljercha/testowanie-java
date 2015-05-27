package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	
	private long id;
	private String make;
	private String model;	
	private int yop;
	
	private Person owner;
	
	public Car(long id, String make, String model, int yop) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.yop = yop;
	}
	
	public Car(long id, String make, String model, int yop, Person owner) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.yop = yop;
		this.owner = owner;
	}
	
	public Car(String make, String model, int yop) {
		this.make = make;
		this.model = model;
		this.yop = yop;
	}
	
	public Car() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
}
