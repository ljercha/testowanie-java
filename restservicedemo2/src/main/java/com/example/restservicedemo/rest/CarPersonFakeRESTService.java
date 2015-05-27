package com.example.restservicedemo.rest;

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
import com.example.restservicedemo.service.CarManager;
import com.example.restservicedemo.service.CarPersonManager;
import com.example.restservicedemo.service.PersonManager;

@Path("carperson")
public class CarPersonFakeRESTService {	
	
	private CarPersonManager cpm = new CarPersonManager();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sellCar(CarPerson carPerson){
		//System.out.println("CARPERSON:" + carPerson.getId_Person() + "\n\n\n\n\n");

		cpm.sellCarPerson(carPerson);
		String result = "Car person added.";
		return Response.status(201).entity(result).build(); 
	}
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "CAR PERSON START";
	}
}
