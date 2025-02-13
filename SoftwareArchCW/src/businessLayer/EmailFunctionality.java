package businessLayer;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  

public class EmailFunctionality
{  
	String sender = "noreply@destore.co.uk"; 
	String host = "localhost";

	public void sendStockEmail(int id, String name, int stock) throws Exception {

		//Get the session object  
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", host);  
		Session session = Session.getInstance(properties);  

		//compose the message  

		String recipient = "manager@destore.co.uk";

		MimeMessage message = new MimeMessage(session);  
		message.setFrom(new InternetAddress(sender));  
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));  
		message.setSubject("Stock Alert");  
		message.setText("The following product has reached a stock level of " + stock + "."
				+ "Product ID: " + id + ", Product Name: " + name + "");  

		// Send message  
		Transport.send(message);   
	}

	public void sendLoyaltyEmail(String name, String email) throws Exception {

		//Get the session object  
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", host);  
		Session session = Session.getInstance(properties);  

		//compose the message  
		String recipient = email;

		MimeMessage message = new MimeMessage(session);  
		message.setFrom(new InternetAddress(sender));  
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));  
		message.setSubject("A personal offer for you!");  
		message.setText("Hi " + name + "! A new promotion is available for you for your continued loyalty!");  

		// Send message  
		Transport.send(message);    
	}

}  