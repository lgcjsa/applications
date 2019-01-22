package luiss.it.beans;

@SuppressWarnings("serial")
public class GeneratoreCodiceFiscaleException extends Exception {
	
	private String message;
	
	public GeneratoreCodiceFiscaleException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
