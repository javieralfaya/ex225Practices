package test;

import javax.jms.JMSException;

import mdb.SenderColaSaludosBean;

public class TestMessagesSender {

	public static void main(String[] args) throws JMSException {
		
		SenderColaSaludosBean aSenderColaSaludosBean = new SenderColaSaludosBean();
		
		aSenderColaSaludosBean.send("hola soy Javi");
	}

}
