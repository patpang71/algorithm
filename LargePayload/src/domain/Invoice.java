/**
 * 
 */
package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ppang
 *
 */
@XmlRootElement(name="Invoice")
public class Invoice {
	private String invoiceId;
	private Calendar invoiceDate;
	private String invoiceTitle;
	
	@XmlElement(name="InvoiceItems")
	private List<InvoiceItem> invoiceItems;
		
	/**
	 * @param invoiceId
	 * @param invoiceDate
	 * @param invoiceTitle
	 * @param invoiceItems
	 */
	public Invoice(String invoiceId, Calendar invoiceDate, String invoiceTitle, List<InvoiceItem> invoiceItems) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.invoiceTitle = invoiceTitle;
		this.invoiceItems = invoiceItems;
	}
	
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Calendar getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Calendar invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	
	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
	
	
}
