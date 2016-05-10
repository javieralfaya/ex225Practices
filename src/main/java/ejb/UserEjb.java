package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

/**
 * Session Bean implementation class UserEjb
 */
@Stateless
@LocalBean
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
	public User createUser(User aUser) {
    	em.persist(aUser);
		return aUser;
	}
    
    @SuppressWarnings("unchecked")
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
    	
    	User aUserGet = new User();
    	aUserGet = em.find(User.class, anUser.getUsername());
    	
    	return aUserGet;
    	
    	
    }

}
