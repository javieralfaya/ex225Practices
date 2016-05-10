package controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@Model
public class LogoutController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6998823306030586536L;


	public LogoutController(){
		
	}

	
	public String logout() throws IOException{
		
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
		         .getSession(false)).invalidate();
		     
	    
		      return "/protected/home/home";
	   
	}
}
