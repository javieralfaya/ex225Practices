package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;
import qualifiers.MyInterceptorBinding;

/**
 * Session Bean implementation class UserEjb
 */
@Stateless
@LocalBean
@TransactionAttribute
public class UserEjb implements UserEjbInterface {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
    public UserEjb() {
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
	 * @see ejb.UserEjbInterface#createUser(model.User)
	 */
    @Override
	public User createUser(User anUser) {
    	
    	em.persist(anUser);
		return anUser;
	}
    
    @Override
    @Named("usersList")
    @Produces
	public List<User> listUsers() {
    	List<User> aListUser = new ArrayList<User>();
    	aListUser = em.createNamedQuery("User.findAll").getResultList();
    	 
    	
    	
		return aListUser;
	}
    
    @Override
    public void deleteUser(User anUser){
    	
    	User userToDelete = new User();
    	
    	userToDelete = em.find(User.class, anUser.getUsername());
    	
    	if (!(userToDelete == null)){
    	
    		em.remove(userToDelete);
    	
    	}
    }
    
    @Override
    public User findUser(User anUser){
    	
    	
    	anUser = em.find(User.class, anUser.getUsername());
    	
    	return anUser;
    	
    	
    }

}
