package com.example.mockdemo.app;


import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.mockdemo.messenger.MessageServiceDummy;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;

public class MessengerSteps {
	
	private Messenger messenger;
	private static final int success = 0;
	private static final int error = 1;
	private static final int otherError = 2;
	private String message = null;
	private String serverName = null;
	@Given("a messenger")
	public void messangerSetup(){
		messenger = new Messenger( new MessageServiceDummy());
	}
	
	@When("set server name to $server")
	public void setServer(String server){
		serverName = server;
	}
	@When("set message text to $text")
	public void setMessage(String text){
		message = text;
	}
	
	@Then("test connection should return $result")
		public void testConnection(int result){
		assertEquals(result, messenger.testConnection(serverName));
		}
	@Then("send message return $result")
	public void send(int result){
	assertEquals(result, messenger.sendMessage(serverName, message));
	}
	/*
    @Then("adding should return $result")
	public void shouldAdd(int result){
		assertEquals(result, calc.add());
	}
    
    @Then("subtracting should return $result")
  	public void shouldSubstract(int result){
  		assertEquals(result, calc.subtract());
  	}*/
}

