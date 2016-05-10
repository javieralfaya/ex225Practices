package mdb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Named;

@Named
@Singleton
public class MessageListBackingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final List<Message> messages = new ArrayList<>();
	
	public MessageListBackingBean() {
		
	}

	public void addMessage(final String text) {
		
		messages.add(new Message(text));
		
	}
	
	public List<Message> getMessages() {
		
		return messages;
		
	}
	
	public static class Message {
		
		private final Date timestamp;
		private final String text;
		
		private Message(final String text) {
			
			timestamp = new Date();
			this.text = text;
			
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public String getText() {
			return text;
		}
		
		
		
	}

}
