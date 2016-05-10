package mdb;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

@Named
public class SenderColaSaludosBean {

	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(final String message) {
		this.message = message;
	}
	
	@Resource(mappedName = "java:/ConnectionFactory")
	private static ConnectionFactory queueConnectionFactory;
	
	@Resource(mappedName = "java:jboss/cola/ColaSaludos")
	private static Queue queue;
	
	public static void send(final String text)
		throws JMSException {
		
		Connection c = null;
		try {
			c = queueConnectionFactory.createConnection();
			final Session s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
			final MessageProducer mp = s.createProducer(queue);
			mp.send(s.createTextMessage(text));
		}
		finally {
			if (c != null) {
				c.close();
			}
		}
		
	}
	
	
	public void send()
		throws JMSException {
		
		send(message);
		message = null;
		
	}

}