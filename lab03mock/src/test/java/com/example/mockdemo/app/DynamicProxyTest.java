package com.example.mockdemo.app;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;




import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class DynamicProxyTest {

	MessageService ms;
	Messenger messenger;
	

	
	@Before
	public void setUp()
	{
		InvocationHandler ih = new IMessageServiceHandler();
		
		ms = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
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
	
	
	class IMessageServiceHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) 
			{
				if(args[0].toString().contains(".pl"))
					return ConnectionStatus.SUCCESS;
				if(args[0].toString().contains(".com"))
					return ConnectionStatus.FAILURE;
				return ConnectionStatus.FAILURE;
			}
			if ("send".equals(method.getName())) 
			{
				if (args[1] == null || args[1].toString().length() < 3)
					throw new MalformedRecipientException();
				
				if (args[0] == null || args[0].toString().length() < 4)
					throw new MalformedRecipientException();
				
				if (ms.checkConnection(args[0].toString()) == ConnectionStatus.FAILURE) {
					return SendingStatus.SENDING_ERROR;
				}
				if (args[1].toString().contains("a") || args[1].toString().contains("e") || 
						args[1].toString().contains("i") || args[1].toString().contains("y") ||
						args[1].toString().contains("o") || args[1].toString().contains("u"))
				return SendingStatus.SENT;
			}
			return 0;
		}
	}
}
