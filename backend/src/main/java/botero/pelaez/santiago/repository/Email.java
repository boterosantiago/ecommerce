package botero.pelaez.santiago.repository;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public void send(String to, String subject, String text) throws AddressException, MessagingException {
		final String emailSender = "correoparapruebasdelauq@gmail.com";
		final String password = "dificildehackear";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // esta propiedad es necesaria

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailSender, password);
			}
		};

		Session sesion = Session.getInstance(props, auth); // la creación de la sesión también cambia

		MimeMessage msg = new MimeMessage(sesion);
		msg.setFrom(new InternetAddress(emailSender));
		msg.setSubject("Ecommerce Authentication", "UTF-8");
		msg.setText(text, "UTF-8");
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false)); // email de destino

		Transport.send(msg); // acá solo se manda el MimeMessage
	}

}