package controllers;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.jboss.netty.handler.codec.http.HttpRequest;

@RequestScoped
@Named
public class HomeController implements Serializable {


	private static final long serialVersionUID = 4037811057093629369L;
	
	public String navigationHome(){
		
		return  "/protected/home/home";
		
	}

}
