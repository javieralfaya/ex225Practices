package decorators;

import java.util.List;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import model.User;
import ejb.UserEjbInterface;

@Decorator
public abstract class UserEjbDecorator implements UserEjbInterface {
	
	private static final Logger LOG = Logger.getLogger(UserEjbDecorator.class);

	@Inject
	@Delegate
	@Any
	private UserEjbInterface userEjbInterface;

	public UserEjbDecorator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User createUser(User aUser) {
		
		LOG.info("############Pasando por decorator");
		return userEjbInterface.createUser(aUser);
	}

	@Override
	public List<User> listUsers() {
		LOG.info("############Pasando por decorator");
		return userEjbInterface.listUsers();
	}

	@Override
	public void deleteUser(User aUser) {
		LOG.info("############Pasando por decorator");
		userEjbInterface.deleteUser(aUser);
	}

	@Override
	public User findUser(User aUSer) {
		LOG.info("############Pasando por decorator");
		return userEjbInterface.findUser(aUSer);
	}

}
