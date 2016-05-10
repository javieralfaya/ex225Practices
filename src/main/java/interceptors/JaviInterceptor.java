package interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import model.Message;

import org.jboss.logging.Logger;

import qualifiers.MyInterceptorBinding;
import qualifiers.ProductorDeMensajes;
import ejb.MessagesEJB;

@Interceptor
@MyInterceptorBinding
public class JaviInterceptor {
	
	
	private static final Logger LOG = Logger.getLogger(JaviInterceptor.class);
	
	@Inject 	
	private MessagesEJB aMessagesEJB;
	
	@Inject
	@ProductorDeMensajes
	private Message aMessage;
	
	
	
	public JaviInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		

		    LOG.info("###########################FIRE JaviInterceptor ############################## ");
			
			aMessage.setMessages("Interceptor MyInterceptor disparado desde:" + ic.getMethod());
			aMessagesEJB.insertMessage(aMessage);
			
			
			
		return null;
	}

}
