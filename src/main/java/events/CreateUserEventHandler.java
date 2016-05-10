package events;

import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import qualifiers.CreateUserEventQualifier;

public class CreateUserEventHandler {
	
	private static final Logger LOG = Logger.getLogger(CreateUserEventHandler.class);
	
	
	public void fireEvent(@Observes @CreateUserEventQualifier CreateUserEvent event){
	    LOG.info("########################################EVENT fire");
		LOG.info(event.toString());
	}

}
