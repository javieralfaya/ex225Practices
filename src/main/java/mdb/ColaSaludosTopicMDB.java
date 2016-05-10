package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ColaSaludosTopicMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "topic/colaSaludosTopic")
		})
public class ColaSaludosTopicMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public ColaSaludosTopicMDB() {
       
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        if (message instanceof TextMessage ){
        	
        	try {
				String textoMensaje = ((TextMessage) message).getText();
				System.out.println("Mensaje con texto:" + textoMensaje);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
    }

}
