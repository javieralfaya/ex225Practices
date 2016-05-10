package ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.User;
import ejb.UserEjbInterface;

@WebService()
public class FindUser {
	
	@Inject 
	private UserEjbInterface aUserEjbInterface;

	@WebMethod()
	public String findUserByName(@WebParam(name="username") String userName) {
		
		User aUser = new User();
		
		aUser.setUsername(userName);
		
		aUser = aUserEjbInterface.findUser(aUser);
		
		if (aUser!=null){
			return "User name:" + aUser.getUsername() + "User password:" + aUser.getPassword();
		}else{
			return "user don't exist";
		}
		
		
	    
		
	}
}
