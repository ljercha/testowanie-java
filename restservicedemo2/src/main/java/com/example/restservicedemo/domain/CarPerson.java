package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarPerson {
	
	public CarPerson(long id, int id_Car, int id_Person) {
		super();
		this.id = id;
		this.id_Car = id_Car;
		this.id_Person = id_Person;
	}
	
	public CarPerson(int id_Car, int id_Person) {
		super();
		this.id_Car = id_Car;
		this.id_Person = id_Person;
	}
	
	public CarPerson() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getId_Car() {
		return id_Car;
	}
	public void setId_Car(int id_Car) {
		this.id_Car = id_Car;
	}
	public int getId_Person() {
		return id_Person;
	}
	public void setId_Person(int id_Person) {
		this.id_Person = id_Person;
	}
	private long id;
	private int id_Car;
	private int id_Person;
}
