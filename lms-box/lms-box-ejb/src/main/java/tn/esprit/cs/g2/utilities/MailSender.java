package tn.esprit.cs.g2.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
@LocalBean
public class MailSender {

	@Resource(name = "java:jboss/mail/Default2")
	private Session session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see tn.esprit.cs.g2.utilities.MailRemote#send(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void send(String addresses, String topic, String textMessage) {

		try {

			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
			message.setSubject(topic);
			message.setText(textMessage);

			Transport.send(message);

		} catch (MessagingException e) {
			Logger.getLogger(MailSender.class.getName()).log(Level.WARNING, "Cannot send mail", e);
		}
	}
}