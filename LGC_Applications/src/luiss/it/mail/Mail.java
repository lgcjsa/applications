package luiss.it.mail;

public abstract class Mail {
	
	public final static String smtp = "mail.luiss.it";
	private String oggetto;
	private String destinatario;
	private StringBuffer testo = new StringBuffer();	 
	private String from;
	
	public StringBuffer getTesto() {
		return testo;
	}
	public void setTesto(StringBuffer testo) {
		this.testo = testo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public abstract void sendTo(String to, String testo) throws Exception;
	public abstract void sendTo(String to) throws Exception;
	public abstract Object getArg();
	public abstract void setArg(Object arg);

	
}
