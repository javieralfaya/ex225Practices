package controllers;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.AssertTrue;

import events.MessagesEvent;
import qualifiers.InsertInMessaggesQualifier;
import qualifiers.InvoiceProducerAnnotation;
import model.Invoice;

@Named("invoiceController")
@RequestScoped
public class InvoiceController implements Serializable {

	private static final long serialVersionUID = 6027470572927688077L;
	
	
	@Inject
	@InvoiceProducerAnnotation
	private Invoice aInvoice;
	
	
	@Inject
	@InsertInMessaggesQualifier
	Event<MessagesEvent> aEvent;
	
	public InvoiceController(){
		
	}
	
	
	public String showInvoiceRF(){
		
		return "/protected/invoicesRF/invoicesRF";
		
	}

	public String showCreateInvoice(){
		
		
		return "/protected/invoices";
	}
	
	public String saveInvoice(){
		
		MessagesEvent fireEvent = new MessagesEvent(InvoiceController.class);
		aEvent.fire(fireEvent);
		
		return "/protected/invoices";
	}
	
	public void validateCompanyName(FacesContext context,
			UIComponent component, Object value) {

		if (!value.equals("UNISYS")) {
			return;
		} else {

			UIInput inputComponent = (UIInput) component;
			inputComponent.setValid(false);
			context.addMessage(component.getClientId(context),
					new FacesMessage("El nombre no puede ser UNISYS"));
		}
	}
	
	@AssertTrue(message = "El nomnbre de la compañia no puede ser COMPANY y el número de items igual a 2")
	public boolean isUnisys(){
		if ("COMPANY".equals(aInvoice.getCompanyName()) && aInvoice.getNumbersOfItems() == 2) {
			return false;
			
		}else{
			return true;
		}
		
	}


	public Invoice getaInvoice() {
		return aInvoice;
	}


	public void setaInvoice(Invoice aInvoice) {
		this.aInvoice = aInvoice;
	}



}
