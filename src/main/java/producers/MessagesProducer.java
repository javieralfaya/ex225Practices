package producers;

import java.io.Serializable;

import javax.enterprise.inject.Produces;

import model.Message;
import qualifiers.ProductorDeMensajes;


public class MessagesProducer implements Serializable{

	private static final long serialVersionUID = -2994529799508886606L;

	@Produces
	@ProductorDeMensajes
	public Message createMessage(){
		
		return new Message();
		
	}

}
