package ejb;

import java.util.List;

import model.User;

public interface UserEjbInterface {

	public abstract User createUser(User aUser);

	List<User> listUsers();

	void deleteUser(User aUser);

	User findUser(User aUSer);

}