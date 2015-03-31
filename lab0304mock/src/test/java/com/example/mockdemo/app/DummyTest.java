package com.example.mockdemo.app;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;



import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceDummy;

public class DummyTest {

	MessageService ms;
	Messenger messenger;
	@Before
	public void setUp()
	{
		ms = new MessageServiceDummy();
		messenger = new Messenger(ms);
	}
	
	@Test
	public void testConnectionFailure()
	{
		assertThat(1,is(messenger.testConnection("google.com")));
	}
	@Test
	public void testConnectionOk()
	{
		assertThat(0,is(messenger.testConnection("onet.pl")));
	}
	
	@Test
	public void testSendMessageSuccess()
	{
		assertThat(0,is(messenger.sendMessage("onet.pl", "dzisiaj")));
	}
	@Test
	public void testSendMessageFailureMessageWrongInput()
	{
		assertThat(0,is(messenger.sendMessage("onet.pl", "tup")));
	}
	
	@Test
	public void testSendMessageServerEmpty()
	{
		assertThat(2,is(messenger.sendMessage("", "dzisiaj")));
	}
	@Test
	public void testSendMessageCheckServerFailure()
	{
		assertThat(1,is(messenger.sendMessage("google.com", "dzisiaj")));
	}
}
