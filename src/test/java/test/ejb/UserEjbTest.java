package test.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.Role;
import model.User;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ejb.UserEjbInterface;

@RunWith(Arquillian.class)
public class UserEjbTest {
	private static Logger LOG = Logger.getLogger(UserEjbTest.class);
	@Deployment
	 public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test-ex225.war")
				.addPackages(true, "ejb")
				.addPackages(true, "model")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
				
	}
	
	
    
	@Inject
	private  UserEjbInterface aUserEjb;



	@Test
	public void testCreateUser() {
		LOG.info("#####TEST#### - StartExec  testCreateUser");
		List<Role> aListRoles = new ArrayList<Role>();
		List<User> aListUser = new ArrayList<User>();
		
		User aUserTest = new User();
		aUserTest.setUsername("test");
		aUserTest.setPassword("test");
		aListUser.add(aUserTest);
		Role aRole = new Role();
		aRole.setRolename("admin");
		aRole.setUsers(aListUser);
		aUserTest.setRoles(aListRoles);	
		User aUserCreate = aUserEjb.createUser(aUserTest);
		assertEquals("test",aUserCreate.getUsername());
		LOG.info("#####TEST#### - EndExec  testCreateUser");
		
	}
	
	@Test
	public void testListUsers() {
		LOG.info("#####TEST#### - StartExec  testListUsers");
		List<User> aListUser = new ArrayList<User>();
		aListUser = aUserEjb.listUsers();
		LOG.info("#####TEST#### - EndExec  testListUsers");
		
		assertTrue(aListUser.size()>0);
		
		
	}
	
	
	/*@Test
	public void testDeleteUser() {
		LOG.info("#####TEST#### - StartExec  testDeleteUser");
		User aUserTest = new User();
		aUserTest.setUsername("test");
		//aUserTest.setPassword("test");
		User aUserToDelete;
		aUserToDelete = aUserEjb.findUser(aUserTest);
		aUserEjb.deleteUser(aUserToDelete);
		assertNull( aUserEjb.findUser(aUserTest));
		LOG.info("#####TEST#### - EndExec testDeleteUser");
		
		
	}*/


	
}
