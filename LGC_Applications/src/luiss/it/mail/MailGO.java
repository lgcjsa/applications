package luiss.it.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailGO extends Mail {

	@Override
	public void sendTo(String to, String testo) throws Exception {
		// TODO Auto-generated method stub

		boolean sessionDebug = false;

		Properties props = System.getProperties();
		props.put("mail.host", Mail.smtp);
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(sessionDebug);

		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(this.getFrom()));
			// InternetAddress[] address = {new InternetAddress(this.cidpt.getEmail())};
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(this.getOggetto());
			msg.setSentDate(new java.util.Date());

			msg.setContent(testo, "text/html");
			Transport.send(msg);

		} catch (MessagingException e) {

			System.out.println("Errore invio mail a:" + ' ' + to);

		}
		
	}

	@Override
	public void sendTo(String to) throws Exception {
		// TODO Auto-generated method stub

		boolean sessionDebug = false;

		Properties props = System.getProperties();
		props.put("mail.host", Mail.smtp);
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(sessionDebug);

		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(this.getFrom()));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(this.getOggetto());
			msg.setSentDate(new java.util.Date());

			msg.setContent(this.getTesto().toString(), "text/html");
			Transport.send(msg);

		} catch (MessagingException e) {

			System.out.println("Errore invio mail a:" + ' ' + to);

		}
		
	}

	@Override
	public Object getArg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArg(Object arg) {
		// TODO Auto-generated method stub
		
	}

}
