package producers;

import java.io.Serializable;

import javax.enterprise.inject.Produces;

import qualifiers.UserProducerAnnotation;
import model.User;

public class UserProducer implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287658440511687060L;

	@Produces 
	@UserProducerAnnotation
	public User createUser(){
		User aUser = new User();
		return aUser;
		
		
	}

}
