package message;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;


public class Producteur {

    public static void main(String[] args) {
    ConnectionFactory connectionFactory=null;
    Queue queue=null;
    
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        TextMessage message = null;        
        final int NUM_MSGS = 3;

        try {
				InitialContext ctx = new InitialContext();		
				connectionFactory = (ConnectionFactory) ctx.lookup("uneConnectionFactoryExo2");
				queue = (Queue) ctx.lookup("uneBAL");
			}
		catch (Exception ex) {
				System.err.println("erreur dans le lookup");
				ex.printStackTrace();
			}
        try {
				connection = connectionFactory.createConnection();
				session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				messageProducer = session.createProducer(queue);
				message = session.createTextMessage();
				System.out.println("Enter msg Number");
				Scanner sc = new Scanner(System.in);  // Create a Scanner object
				int num =0;
				num = sc.nextInt();
				switch(num) {
				  case 1:
				    message.setText("This is message " + num);
				 	System.out.println("Sending message: " + message.getText());
				 	messageProducer.send(message);
				    break;
				  case 2:
				    message.setText("This is message " + num);
				 	System.out.println("Sending message: " + message.getText());
				 	messageProducer.send(message);
				 	break;
				  case 3:
				    message.setText("This is message " + num);
				 	System.out.println("Sending message: " + message.getText());
				 	messageProducer.send(message);
				 	break;
				  case 4:
				    message.setText("This is message " + num);
				 	System.out.println("Sending message: " + message.getText());
				 	messageProducer.send(message);
				    break;

				  default:
				    // code block
				}

				// for (int i = 0; i < NUM_MSGS; i++) {
				// 	message.setText("This is message " + (i + 1));
				// 	System.out.println("Sending message: " + message.getText());
				// 	messageProducer.send(message);
				// }	
				
				connection.close();
				System.exit(0);
			} 
			catch (JMSException e) {
					System.out.println("Exception occurred: " + e.toString());
				}
    } // main
} // class
