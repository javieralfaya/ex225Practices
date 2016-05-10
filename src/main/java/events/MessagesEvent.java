package events;

public class MessagesEvent {
	
	
	private Object invocationObject;
	
	public MessagesEvent(Object invocationObject){
		
		this.invocationObject = invocationObject;
	}

	public Object getInvocationObject() {
		return invocationObject;
	}

	public void setInvocationObject(Object invocationObject) {
		this.invocationObject = invocationObject;
	}

}
