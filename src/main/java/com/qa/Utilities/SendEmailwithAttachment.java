package com.qa.Utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



import org.openqa.selenium.WebDriver;

import com.qa.MainFunctions.DriverCalling;

public class SendEmailwithAttachment extends DriverCalling {
	
	static WebDriver driver = null;
	
	public SendEmailwithAttachment(WebDriver driver) {
		SendEmailwithAttachment.driver = driver;
	}
	
	public void sendEmail(String TC_ID , String dest,String datafilename)
	{
		  String to = dest;

	      // Sender's email ID needs to be mentioned
	      String from = ExcelHandling.GetExcelData(TC_ID, "Sender");

	      final String username = ExcelHandling.GetExcelData(TC_ID, "Sender");//change accordingly
	      final String password = ExcelHandling.GetExcelData(TC_ID, "SenderPwd");//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";//"relay.jangosmtp.net";//"smtp.office365.com"

	      Properties props = null;
	      if (props == null) {
	          props = new Properties();
	          props.put("mail.smtp.auth", true);
	          props.put("mail.smtp.starttls.enable", true);
	          props.put("mail.smtp.host", host);
	          props.put("mail.smtp.port", "25");
	          props.put("mail.smtp.socketFactory.port", "587");
	          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	          props.put("mail.smtp.socketFactory.fallback", "true");
	          props.put("mail.smtp.user", username);
	          props.put("mail.smtp.pwd", password);
	      }

	      // Get the Session object.
	       Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });
	    		  // session.setDebug(true);

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Sending mail from Automation");

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText(ExcelHandling.GetExcelData(TC_ID, "Text"));

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = datafilename;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
	
	public void sendmail(String dest,String datafilename)
	{
		final String username = "receiver@gebbs.com";//change accordingly
	      final String password = "receiverpassword";//change accordingly

		Properties props = new Properties();
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");

        try
        {
        Authenticator auth = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          };

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        msg.setText("Hey, this is the testing email.");
        msg.setSubject("Testing");
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(dest));
        Transport.send(msg);

        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
	   }
}
