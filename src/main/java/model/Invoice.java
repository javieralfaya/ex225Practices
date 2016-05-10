package model;

import java.math.BigDecimal;

import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Named("invoice")
public class Invoice {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long invoiceNumber;
	private String companyName;
	private String contactName;
	private String email;
	@DecimalMin(value="0.01", message = "el valor no puese ser inferior a 0,01 --JSR 303 Message")
	private BigDecimal amount;
	@Min( value = 1, message =  "El numero de items no puede ser inferior a 1 --JSR 303 Message")
	private int numbersOfItems;
	private boolean taxable;
	private String taxType;
	private String comments;
	private String source;
	//private Timestamp when = new Timestamp(System.currentTimeMillis());
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getNumbersOfItems() {
		return numbersOfItems;
	}
	public void setNumbersOfItems(int numbersOfItems) {
		this.numbersOfItems = numbersOfItems;
	}
	public boolean isTaxable() {
		return taxable;
	}
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	public String getTaxType() {
		return taxType;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	
}
