package controllers;


import javax.enterprise.inject.Model;
import javax.jms.JMSException;

import mdb.SenderBean;


@Model
public class SenderController {
	
	public SenderController(){
		
	}
	
	public void sendMessage() throws JMSException{
		
		
		SenderBean aSenderBean = new SenderBean();
		
		aSenderBean.send("hola");
		
		
	}

}
