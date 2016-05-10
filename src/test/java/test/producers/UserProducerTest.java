package test.producers;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import model.User;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import qualifiers.UserProducerAnnotation;
import test.base.BaseTest;

@RunWith(Arquillian.class)
public class UserProducerTest extends BaseTest {


//	@Deployment
//	public static JavaArchive createDeployment(){
//		
//		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test-userproducer.jar")
//				.addPackages(true,"qualifiers")
//				.addPackages(true,"interceptors")
//				.addPackages(true,"model")
//				.addPackages(true,"producers")
//				.addPackages(true,"decorators")
//				.addPackages(true,"ejb")
//				.addAsManifestResource(new File("src/main/webapp/WEB-INF/beans.xml"))
//				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
//		
//		return jar;
//		
//		
//		
//	}
	
	
	@Inject 
	@UserProducerAnnotation
	User aUser;
	
	
	@Test
	public void test() {
		assertNotNull(aUser);
	}

}
