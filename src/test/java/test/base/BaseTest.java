package test.base;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BaseTest {

	
	@Deployment
	public static JavaArchive createDeployment(){
		
		final JavaArchive archiveJar = ShrinkWrap.create(JavaArchive.class,"test-ex225.jar")
				.addPackages(true,"qualifiers")
				.addPackages(true,"interceptors")
				.addPackages(true,"model")
				.addPackages(true,"producers")
				.addPackages(true,"decorators")
				.addPackages(true,"ejb")
				.addPackages(true,"test.base")
				.addAsManifestResource(new File("src/main/webapp/WEB-INF/beans.xml"))
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
		return archiveJar;
	}
	
	public BaseTest(){
		
		super();
	}
	
	

}
