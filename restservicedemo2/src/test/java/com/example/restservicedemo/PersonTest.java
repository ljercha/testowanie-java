package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.MatcherAssert.* ;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.CarPerson;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo";
	}
	
	@Test
	public void getAllPerson(){
		get("/persons/all").then().assertThat().body("person[1].firstName", equalTo("Lolek"));
		Person aPerson = get("/persons/0").as(Person.class);
		assertThat(aPerson.getYob(), equalTo(1993));
	}
	
	@Test
	public void addPerson(){
		
		Person aPerson = new Person( "Tester" + new Random().nextInt(100), 1993);
		given().
		       contentType("application/json; charset=UTF-16").
		       body(aPerson).
		when().	     
		post("/persons/").then().assertThat().statusCode(201);
	}
	@Test
	public void addPerson2(){
		
		Person aPerson = new Person( "Lolek", 1992);
		given().
		       contentType("application/json; charset=UTF-16").
		       body(aPerson).
		when().	     
		post("/persons/").then().assertThat().statusCode(201);
	}
	
	@Test
	public void sellCall(){
		
		//Person aPerson = new Person(2, "Andzej", 1990);
		//Car car = new Car(2,"test","test",2004);
		CarPerson cp = new CarPerson(1, 1);
		given().
		       contentType("application/json; charset=UTF-16").
		       body(cp).
		when().	     
		post("/carperson/").then().assertThat().statusCode(201);
	}
	

	
}
