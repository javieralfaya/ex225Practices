package ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Message;

/**
 * Session Bean implementation class MessagesEJB
 */
@Stateless
@LocalBean
public class MessagesEJB implements MessagesEjbInterface {

    /**
     * Default constructor. 
     */
    public MessagesEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext
    private EntityManager em;
    
    /* (non-Javadoc)
	 * @see ejb.MessagesEjbInterface#insertMessage(model.Message)
	 */
    @Override
	public void insertMessage(Message aMessage){
    	
    	aMessage.setDate(new Date());
    	em.persist(aMessage);
    	
    	
    }
    @Override
    public List<Message> getMessagesList(){
    
    	CriteriaQuery<Message> aCriteria = em.getCriteriaBuilder().createQuery(Message.class);
    	Root<Message> messageRoot = aCriteria.from( Message.class );
    	return em.createQuery(aCriteria).getResultList();
    	
    	
    }
}
