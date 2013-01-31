/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author fef
 */
public class UserEmail {
    String host = "mail.teame4t.co.uk";
    String username = "monster-mash-n06@teame4t.co.uk";
    String password = "password";
    
    public boolean send(String to, String from, String subject, String message){
        sendEmail(new Email(to, from, subject, message));
        return false;
    }

    private boolean sendEmail(Email email){

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth","true");
        
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, auth);

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(email.from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                                          new InternetAddress(email.to));

            // Set Subject: header field
            message.setSubject(email.subject);

            // Now set the actual message
            message.setText(email.message);

            // Send message
            Transport.send(message);

        }catch (MessagingException mex) {
            //fail
            mex.printStackTrace
();
            return false;
        }
        return true;
    }

}

class Email{
    public String subject;
    public String to;
    public String from;
    public String message;

    public Email(String email, 
            String from,
            String subject,
            String message){
        this.subject = subject;
        this.to = email;
        this.from = from;
        this.message = message;
    }
}