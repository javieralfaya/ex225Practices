package rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.User;
import ejb.UserEjbInterface;

@RequestScoped
@Path("users/user")
public class FindUsers {
	
	@Inject
	private UserEjbInterface aUserEjbInterface;
	
	@GET()
	@Path("{username}")
	@Produces("text/plain")
	public String getUser(@PathParam(value = "username") String userName){
		
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
