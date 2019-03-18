package message;

import javax.ejb.*;
import javax.jms.*;

@MessageDriven(mappedName = "uneBALExo2")
public class SimpleMessageBean implements MessageListener {

    public SimpleMessageBean() {
    }

    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
				// structure de l'info dans un msg
				// IDmessage : s'affiche dans l'id du msg, pas dans le texte
				// tout ce qui suit les : de IDmessage constitue le texte qui s'affiche
                System.out.println("Message recu: " + msg.getText());
            } else {
                System.out.println(
                        "Message of wrong type: "
                        + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
