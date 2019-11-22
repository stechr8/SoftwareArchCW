package businessLayer;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  

public class EmailFunctionality  
{  
	String recipient = "40281448@live.napier.ac.uk";
	String sender = "stechr@hotmail.co.uk"; 
	String host = "localhost";
	
	public void sendEmail(int id, String name, int stock) {
		
		//Get the session object  
				Properties properties = System.getProperties();  
				properties.setProperty("mail.smtp.host", host);  
				Session session = Session.getInstance(properties);  

				//compose the message  
				try{  

					MimeMessage message = new MimeMessage(session);  
					message.setFrom(new InternetAddress(sender));  
					message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));  
					message.setSubject("Stock Alert");  
					message.setText("The following product has reached a stock level of " + stock + "."
							+ "Product ID: " + id + ", Product Name: " + name + "");  

					// Send message  
					Transport.send(message);  
					System.out.println("message sent successfully....");  

				}catch (MessagingException mex) {
					mex.printStackTrace();
				}  
		
	}
}  