package ejb;

import model.Messagesjm;

public interface MessagesJMSEJBRemote {

	/* (non-Javadoc)
	 * @see ejb.MessagesJMSEJBLocal#storeMessage(model.Messagesjm)
	 */
	public abstract Messagesjm storeMessage(Messagesjm aMessagesjm);

}