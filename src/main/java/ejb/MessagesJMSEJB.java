package ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Messagesjm;

/**
 * Session Bean implementation class MessagesJMSEJB
 */
@Stateless
@Local(MessagesJMSEJBLocal.class)
@Remote(MessagesJMSEJBRemote.class)
public class MessagesJMSEJB implements MessagesJMSEJBRemote, MessagesJMSEJBLocal {

    /**
     * Default constructor. 
     */
    public MessagesJMSEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager em;
    
    /* (non-Javadoc)
	 * @see ejb.MessagesJMSEJBLocal#storeMessage(model.Messagesjm)
	 */
    /* (non-Javadoc)
	 * @see ejb.MessagesJMSEJBRemote#storeMessage(model.Messagesjm)
	 */
    @Override
	public Messagesjm storeMessage(Messagesjm aMessagesjm){
    	
    	Messagesjm aPersistMessagesjm = new Messagesjm();
    	
    	em.persist(aMessagesjm);
    	
    	aPersistMessagesjm = em.find(Messagesjm.class, aMessagesjm.getId());
    	
    	return aPersistMessagesjm;
    	
    }

}
