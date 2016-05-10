package test.producers;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import model.Invoice;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import qualifiers.InvoiceProducerAnnotation;
import test.base.BaseTest;

@RunWith(Arquillian.class)
public class InvoiceProducerTest extends BaseTest {
	
	
	
	@Inject
	@InvoiceProducerAnnotation
	Invoice aInvoice;
	


	@Test
	public void test() {
		
		assertNotNull(aInvoice);
		
	}

}
