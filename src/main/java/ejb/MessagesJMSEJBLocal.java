package ejb;

import model.Messagesjm;

public interface MessagesJMSEJBLocal {

	public abstract Messagesjm storeMessage(Messagesjm aMessagesjm);

}