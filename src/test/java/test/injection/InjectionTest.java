package test.injection;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.base.BaseTest;
import ejb.UserEjb;

@RunWith(Arquillian.class)
public class InjectionTest extends BaseTest{
	
	
	@Inject
	UserEjb aUserEjb;

	@Test
	public void test() {
		assertNotNull(aUserEjb);
	}

}
