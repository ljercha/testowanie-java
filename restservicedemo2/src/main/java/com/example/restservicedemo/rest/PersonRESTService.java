package com.example.restservicedemo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.CarPerson;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.*;

@Path("persons")
public class PersonRESTService {	
	
	private PersonManager pm = new PersonManager();

	@GET
	@Path("/{personId}")
	@Produces("application/json")
	public Person getPerson(@PathParam("personId") Long id){
		Person p = pm.getPerson(id);
		return p;
	}
	@GET
	@Path("/cars/{personId}")
	@Produces("application/json")
	public Person getPersonWithCars(@PathParam("personId") Long id){
		Person p = pm.getPersonWithCars(id);
		return p;
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Person> getAllPersons(@PathParam("personId") Long id){
		return pm.getAllPersons();
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person){
		System.out.println("Person" + person.getFirstName());
		pm.addPerson(person);
		String result = "Person saved: " + person;
		return Response.status(201).entity(result).build();  
	}

	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}

}
