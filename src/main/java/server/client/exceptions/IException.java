package server.client.exceptions;

public class IException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public IException(String pMessage) {
		message = pMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
