package it.xpug.kata.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPMessageSender implements MessageSender {
    private final String smtpHost;
    private final int smtpPort;

    public SMTPMessageSender(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    public void send(BirthdayGreeting greeting) {
        try {
            sendSmtpMessage(greeting);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void sendSmtpMessage(BirthdayGreeting greeting) throws MessagingException {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        Session session = Session.getInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sender@here.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(greeting.getRecipient()));
        msg.setSubject(greeting.getSubject());
        msg.setText(greeting.getBody());

        // Send the message
        Transport.send(msg);
    }
}
