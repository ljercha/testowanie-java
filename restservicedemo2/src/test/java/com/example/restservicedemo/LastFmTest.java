package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.MatcherAssert.* ;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.xml.element.Node;
import com.jayway.restassured.response.*;

public class LastFmTest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://ws.audioscrobbler.com";
		RestAssured.basePath = "/2.0";
	}
	public final static String apiKey = "5f28e9c03d6afbd2b614fcb7ead6b5e5";
	@Test
	public void getAlbumInfo(){
		get("/?method=album.getinfo&api_key=" + apiKey + "&artist=Cher&album=Believe&format=json")
				.then().assertThat().body("album.releasedate", containsString("Jul 2005, 00:00"));
	}
	
	@Test
	public void getGeoInfo(){
		get("http://ws.audioscrobbler.com/2.0/?method=geo.getevents&location=madrid&api_key=5f28e9c03d6afbd2b614fcb7ead6b5e5")
				.then().assertThat().body("lfm.events.event.title", hasItem("Toundra"));
	}
	
}
