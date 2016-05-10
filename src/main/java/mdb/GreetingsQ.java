package mdb;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import model.Messagesjm;

import org.jboss.logging.Logger;

import ejb.MessagesJMSEJBLocal;

/**
 * Message-Driven Bean implementation class for: GreetingsQ
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "/cola/ColaSaludos")
		}, 
		mappedName = "/cola/ColaSaludos")
public class GreetingsQ implements MessageListener {
	
	private static Logger LOG = Logger.getLogger(GreetingsQ.class);
	
	@Inject
	private MessagesJMSEJBLocal aMessagesJMSEJBLocal;
	
	@Inject 
	private MessageListBackingBean list;

    /**
     * Default constructor. 
     */
    public GreetingsQ() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
       
    	if (message instanceof TextMessage ){
    		try {
    			String messageText = "";
				messageText = ((TextMessage) message).getText();
				Messagesjm aMessagesjm = new Messagesjm();
				aMessagesjm.setMessages(messageText);
				aMessagesjm.setDate(new Date());
				//aMessagesJMSEJBLocal.storeMessage(aMessagesjm);
				list.addMessage(messageText);
			} catch (JMSException aJMSException) {
				LOG.error("Exception into GreetingsQ.onMessage", aJMSException);
				
				
			}
    		
    	}
        
    }

}
