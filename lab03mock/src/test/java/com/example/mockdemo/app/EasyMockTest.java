package com.example.mockdemo.app;

import static org.easymock.EasyMock.createMock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.mockdemo.app.DynamicProxyTest.IMessageServiceHandler;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {
	

	MessageService mock;
	Messenger messenger;

	@Before
	public void setUp() throws MalformedRecipientException
	{
		mock = createMock(MessageService.class);
		messenger = new Messenger(mock);
		
	//	expect(mock.send(anyString(), anyString())).andThrow(new MalformedRecipientException());
//		expect(mock.send("\\w{4,}","\\w{3,}")).andReturn(SendingStatus.SENT);
		//expect(mock.send(anyString(),anyString())).andReturn(SendingStatus.SENDING_ERROR);
	//	replay(mock);
//		verify(mock);
	}
	
	@Test
	public void testConnectionFailure()
	{
		expect(mock.checkConnection(anyString())).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertThat(1,is(messenger.testConnection("google.com")));
		verify(mock);
	}
	@Test
	public void testConnectionOk()
	{
		expect(mock.checkConnection(matches(".*\\.pl"))).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertThat(0,is(messenger.testConnection("onet.pl")));
		verify(mock);
	}
	
	@Test
	public void testSendMessageSuccess() throws MalformedRecipientException
	{
		expect(mock.send("onet.pl","dzisiaj")).andReturn(SendingStatus.SENT);
		replay(mock);
		
		assertThat(0,is(messenger.sendMessage("onet.pl", "dzisiaj")));
		verify(mock);
	}
	@Test
	public void testSendMessageFailureMessageWrongInput() throws MalformedRecipientException
	{
		expect(mock.send("onet.pl","tup")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertThat(2,is(messenger.sendMessage("onet.pl", "tup")));
		verify(mock);
	}
	
	@Test
	public void testSendMessageServerEmpty() throws MalformedRecipientException
	{
		expect(mock.send("","dzisiaj")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertThat(2,is(messenger.sendMessage("", "dzisiaj")));
		verify(mock);
	}
	@Test
	public void testSendMessageCheckServerFailure() throws MalformedRecipientException
	{
		expect(mock.send("google.com","dzisiaj")).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertThat(1,is(messenger.sendMessage("google.com", "dzisiaj")));
		verify(mock);
	}


}
