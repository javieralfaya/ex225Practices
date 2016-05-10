package mdb;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

@Model
public class SenderColaSaludosTopic {

	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(final String message) {
		this.message = message;
	}
	
	@Resource(mappedName = "java:/ConnectionFactory")
	//@Resource(mappedName = "java:jboss/exported/jms/RemoteConnectionFactory")
	private static TopicConnectionFactory  aTopicConnectionFactory;
	
	
	public static void send(final String text)
		throws JMSException {
		
		 TopicConnection topicConnection = null;
		
		try {
			topicConnection = aTopicConnectionFactory.createTopicConnection();
			
			final TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = topicSession.createTopic("ColaSaludosTopic");
			TopicPublisher topicPublisher = 
		              topicSession.createPublisher(topic);
			
			 TextMessage textMessage = 
		              topicSession.createTextMessage();
			 
			 textMessage.setText(text);
	            topicPublisher.publish(textMessage);
			
			
		

		}
		finally {
			if (topicConnection != null) {
				topicConnection.close();
			}
		}
		
	}
	
	
	public void send()
		throws JMSException {
		
		send(message);
		message = null;
		
	}

}