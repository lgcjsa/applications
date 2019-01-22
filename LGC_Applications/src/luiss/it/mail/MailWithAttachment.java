package luiss.it.mail;

import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import luiss.it.TRIENNALI_INT.dao.Preweb;

   
public class MailWithAttachment extends Mail {
      	
	private Preweb arg;
	
	public void sendTo(String to, String testo) {

		boolean sessionDebug = false;
		
		Properties props = System.getProperties();
		props.put("mail.host", Mail.smtp);
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(sessionDebug);
      		
		try {
		  
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(this.getFrom()));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(this.getOggetto());
			msg.setSentDate(new java.util.Date());
			 
			msg.setContent(testo,"text/html");
			Transport.send(msg);
			
		} catch (MessagingException e) {
			
			System.out.println("Errore invio mail a:" + ' ' + to);

		}
			
		
	}
	
	public void sendTo(String to) {
		
		try {
		
		// Get system properties
		 Properties props = System.getProperties();
		 
		 // Setup mail server
		 props.put("mail.smtp.host", Mail.smtp);

		 // Get session
		 Session session = Session.getDefaultInstance(props, null);

		 // Define message
		 MimeMessage message = new MimeMessage(session);
		 message.setFrom(new InternetAddress(this.getFrom()));
		 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 message.setSubject(this.getOggetto());

		 // Create the multi-part
		 Multipart multipart = new MimeMultipart();

		 // Create part one
		 BodyPart messageBodyPart = new MimeBodyPart();

		 // Fill the message
		 //messageBodyPart.setText(testo.toString());
		 messageBodyPart.setContent(this.getTesto().toString(), "text/html");
		 // Add the first part
		 multipart.addBodyPart(messageBodyPart);

		 // Part two is attachment
		 messageBodyPart = new MimeBodyPart();
		 DataSource source = new URLDataSource( new URL("http://localhost:8080/LGC_Applications/DomandaPDF?anno=" + this.arg.getId().getAnno() + "&sessione=" + this.arg.getId().getSessione() + "&cf=" + this.arg.getId().getCf().toUpperCase() + "&currentTimeMillis=" + new Long(System.currentTimeMillis()).toString()));
		 messageBodyPart.setDataHandler(new DataHandler(source));
		 messageBodyPart.setFileName("Application.pdf");
		 
		  
		 // Add the second part
		 multipart.addBodyPart(messageBodyPart);

		 // Put parts in message
		 message.setContent(multipart);
	
		 Transport.send(message);		 
		 
		 } catch (Exception e ) {
		
			System.out.println("Errore invio mail a:" + ' ' + to);
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			
		 }	
		
	}
	
	public Object getArg() {
		return this.arg;
	}
	
	public void setArg(Object arg) {
		this.arg = (Preweb) arg;
	}
	 
	    
}
