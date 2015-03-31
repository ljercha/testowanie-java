package com.example.mockdemo.messenger;

public class MessageServiceDummy implements MessageService {


	public ConnectionStatus checkConnection(String server) {
		// checking the server here ...
		if (!server.endsWith(".pl")) {
			return ConnectionStatus.FAILURE;
		}
		// ...
		return ConnectionStatus.SUCCESS;
	}

	public SendingStatus send(String server, String message)
			throws MalformedRecipientException {

		if (message == null || message.length() < 3)
			throw new MalformedRecipientException();
		
		if (server == null || server.length() < 4)
			throw new MalformedRecipientException();
		
		if (checkConnection(server) == ConnectionStatus.FAILURE) {
			return SendingStatus.SENDING_ERROR;
		}

		// sending logic here ...
		if (message.contains("a") || message.contains("e") || 
			message.contains("i") || message.contains("y") ||
			message.contains("o") || message.contains("u")) {
			return SendingStatus.SENT;
		}
		return SendingStatus.SENDING_ERROR;
	}


}
