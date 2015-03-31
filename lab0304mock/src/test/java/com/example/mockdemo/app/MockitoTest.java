package com.example.mockdemo.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;




import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;

import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

	@Spy
	MessageServiceSimpleImpl spy;
	MessageService mock;
	
	MessageServiceSimpleImpl messageServiceSimpleImpl = new MessageServiceSimpleImpl();
	Messenger messenger;
	
	private static final int success = 0;
	private static final int error = 1;
	private static final int otherError = 2;
	private static final String correctMessage = "dzisiaj";
	private static final String wrongMessage = "to";
	private static final String correctServer = "onet.pl";
	private static final String wrongServer = "google.com";
	private static final String emptyServer = "";
	@Before
	public void setUp() {
		spy = spy(messageServiceSimpleImpl);
		mock = mock(MessageService.class);
		messenger = new Messenger(mock);
	}

	@Test(expected = MalformedRecipientException.class)
	public void spyTest() throws MalformedRecipientException {
		when(spy.checkConnection(anyString())).thenCallRealMethod();
		when(spy.send(anyString(), anyString())).thenAnswer(
				new Answer<SendingStatus>() {

					@Override
					public SendingStatus answer(InvocationOnMock invocation)
							throws Throwable {

						MessageServiceSimpleImpl mock = (MessageServiceSimpleImpl) invocation
								.getMock();
						Object[] args = invocation.getArguments();

						// calling real method
						if (mock.checkConnection(args[0].toString()) == ConnectionStatus.FAILURE)
							return SendingStatus.SENDING_ERROR;

						if (args[0].toString().length() < 4
								|| args[1].toString().length() < 3)
							throw new MalformedRecipientException();

						return SendingStatus.SENT;
					}

				});
		messenger = new Messenger(spy);

		assertEquals(success, messenger.sendMessage(wrongServer, correctMessage));
		messenger.sendMessage(wrongServer, correctMessage);

		verify(spy).checkConnection(wrongServer);
		verify(spy).send(wrongServer, correctMessage);
	}

	@Test
	public void testConnectionFailure() {
		when(mock.checkConnection(anyString())).thenReturn(
				ConnectionStatus.FAILURE);
		assertThat(error, is(messenger.testConnection(wrongServer)));
		verify(mock).checkConnection(wrongServer);
	}

	@Test
	public void testConnectionOk() {
		given(mock.checkConnection(contains(".pl"))).willReturn(
				ConnectionStatus.SUCCESS);
		assertThat(success, is(messenger.testConnection(correctServer)));
		verify(mock).checkConnection(correctServer);
	}

	@Test
	public void testSendMessageSuccess() throws MalformedRecipientException {
		given(mock.send(correctServer, correctMessage)).willReturn(SendingStatus.SENT);
		assertThat(success, is(messenger.sendMessage(correctServer, correctMessage)));
		verify(mock).send(correctServer, correctMessage);
	}

	@Test
	public void testSendMessageFailureMessageWrongInput()
			throws MalformedRecipientException {
		given(mock.send(correctServer, wrongMessage)).willAnswer(
				new Answer<SendingStatus>() {
					@Override
					public SendingStatus answer(InvocationOnMock invocation)
							throws Throwable {
						Object args[] = invocation.getArguments();
						if (args[1] == null || args[1].toString().length() < 3)
							throw new MalformedRecipientException();
						if (args[0] == null || args[0].toString().length() < 4)
							throw new MalformedRecipientException();
						return SendingStatus.SENT;
					}
				});

		assertThat(otherError, is(messenger.sendMessage(correctServer, wrongMessage)));
		verify(mock).send(correctServer, wrongMessage);
	}

	@Test
	public void testSendMessageServerEmpty() throws MalformedRecipientException {
		given(mock.send(eq(emptyServer), eq(correctMessage))).willThrow(
				new MalformedRecipientException());
		assertThat(otherError, is(messenger.sendMessage(emptyServer, correctMessage)));
		verify(mock).send(emptyServer, correctMessage);
	}

	@Test
	public void testSendMessageCheckServerFailure()
			throws MalformedRecipientException {
		given(mock.send(eq(wrongServer), eq(correctMessage))).willReturn(
				SendingStatus.SENDING_ERROR);
		assertThat(error, is(messenger.sendMessage(wrongServer, correctMessage)));
		verify(mock).send(wrongServer, correctMessage);
	}
}
