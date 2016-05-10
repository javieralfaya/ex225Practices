package ejb;

import java.util.List;

import model.Message;

public interface MessagesEjbInterface {

	public abstract void insertMessage(Message aMessage);

	List<Message> getMessagesList();

}