package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.MatcherAssert.* ;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;

public class CarServiceTest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo";
	}
	
	@Test
	public void getCar(){
		get("/cars/0").then().assertThat().body("model", equalTo("Corsa"));
		get("/cars/0").then().assertThat().
		body(matchesJsonSchemaInClasspath("car.json"));

		
		Car aCar = get("/cars/0").as(Car.class);
		assertThat(aCar.getMake(), equalToIgnoringCase("Opel"));
	}
	@Test
	public void getOwner(){
		get("/cars/0").then().assertThat().body("owner.yob", equalTo("1999"));

		
		Car aCar = get("/cars/0").as(Car.class);
		assertThat(aCar.getOwner().getFirstName(), equalToIgnoringCase("Lucius"));
	}
	
	@Test
	public void addCar(){
		
		Car aCar = new Car( "Opel", "Yaris", 2000);
		given().
		       contentType("application/json; charset=UTF-16").
		       body(aCar).
		       when().	     
		       post("/cars/").then().assertThat().statusCode(201);
	}


	

}
