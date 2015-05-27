package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpecialTest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo";
	}
	
	@Test
	public void getPersonWithCars(){
		
		Person person = get("persons/cars/1").body().as(Person.class);
		
		for (Car car : person.getCars()) {
			assertThat(car.getMake(), is("Opel"));
		}
	}
	
	@Test
	public void getSecondCarOwnedByPerson(){
		
		get("/cars/person/1").then().assertThat().body("car[1].model",equalTo("Omega"));
	}
}
