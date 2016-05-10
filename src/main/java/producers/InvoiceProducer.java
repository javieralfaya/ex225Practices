package producers;

import java.io.Serializable;

import javax.enterprise.inject.Produces;



import qualifiers.InvoiceProducerAnnotation;
import model.Invoice;


public class InvoiceProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6727744203850655936L;
	
	@Produces 
	@InvoiceProducerAnnotation
	public Invoice generateInvoice( ){
		
		Invoice aInvoice = new Invoice();
		return aInvoice;
		
	}
	
	
	

}
