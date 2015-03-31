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
	
	private static final int success = 0;
	private static final int error = 1;
	private static final int otherError = 2;
	private static final String correctMessage = "dzisiaj";
	private static final String wrongMessage = "to";
	private static final String correctServer = "onet.pl";
	private static final String  wrongServer = "google.com";
	private static final String emptyServer = "";
	MessageService mock;
	Messenger messenger;

	@Before
	public void setUp() throws MalformedRecipientException
	{
		mock = createMock(MessageService.class);
		messenger = new Messenger(mock);
		
	}
	
	@Test
	public void testConnectionFailure()
	{
		expect(mock.checkConnection(anyString())).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertThat(error,is(messenger.testConnection(wrongServer)));
		verify(mock);
	}
	@Test
	public void testConnectionOk()
	{
		expect(mock.checkConnection(matches(".*\\.pl"))).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertThat(success,is(messenger.testConnection(correctServer)));
		verify(mock);
	}
	
	@Test
	public void testSendMessageSuccess() throws MalformedRecipientException
	{
		expect(mock.send(correctServer,correctMessage)).andReturn(SendingStatus.SENT);
		replay(mock);
		
		assertThat(success,is(messenger.sendMessage(correctServer, correctMessage)));
		verify(mock);
	}
	@Test
	public void testSendMessageFailureMessageWrongInput() throws MalformedRecipientException
	{
		expect(mock.send(correctServer,wrongMessage)).andThrow(new MalformedRecipientException());
		replay(mock);
		assertThat(otherError,is(messenger.sendMessage(correctServer, wrongMessage)));
		verify(mock);
	}
	
	@Test
	public void testSendMessageServerEmpty() throws MalformedRecipientException
	{
		expect(mock.send(emptyServer,correctMessage)).andThrow(new MalformedRecipientException());
		replay(mock);
		assertThat(otherError,is(messenger.sendMessage(emptyServer, correctMessage)));
		verify(mock);
	}
	@Test
	public void testSendMessageCheckServerFailure() throws MalformedRecipientException
	{
		expect(mock.send(wrongServer,correctMessage)).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertThat(error,is(messenger.sendMessage(wrongServer, correctMessage)));
		verify(mock);
	}


}
