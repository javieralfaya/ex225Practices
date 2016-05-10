package events;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import model.Message;

import org.jboss.logging.Logger;

import ejb.MessagesEJB;
import qualifiers.InsertInMessaggesQualifier;

public class MessagesEventHandler implements Serializable {


	private static final long serialVersionUID = -2927356537580513568L;
	private static Logger LOG = Logger.getLogger(MessagesEventHandler.class);
	
    @Inject 
    private MessagesEJB aMessagesEJB;
    
	public void insertInTableMessages(@Observes @InsertInMessaggesQualifier MessagesEvent aMessageesEvent){
		
		LOG.info("Event MessagesEvent Method @InsertInMessaggesQualifier FIREEEEEEEEEEEEEEEEEEEE");
		
		Message aMessage = new Message();
		aMessage.setMessages("Insert Message from invocation object:" + aMessageesEvent.getInvocationObject().toString());
		
		aMessagesEJB.insertMessage(aMessage);
		
		
		
		
		
		
		
	}

}
