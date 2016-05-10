package test.ejb;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import model.Message;

import org.junit.Test;

import test.base.BaseTest;
import ejb.MessagesEJB;

public class MessageEJBTest extends BaseTest {
	
	
	@Inject 
	MessagesEJB aMessagesEJB;

	@Test
	public void testMessagesList() {
		
		List<Message> aListMessage = aMessagesEJB.getMessagesList();
		
	  assertTrue(aListMessage.size()>0);
	   
	   for (Message aMessage:aListMessage){
		   System.out.println(aMessage.getMessages());
	   }
	}

}
