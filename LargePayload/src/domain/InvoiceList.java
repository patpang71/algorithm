package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Invoice.class)
public class InvoiceList extends ArrayList<Invoice> {
	private static final long serialVersionUID = 1L;

	public InvoiceList() {
		super();
	}
	
	public InvoiceList(Collection<? extends Invoice> c) {
		super(c);
	}
	
	@XmlElement(name = "Invoices")
	public List<Invoice> getInovices() {
		return this;
	}
	
	public void addInovice(List<Invoice> inv) {
		this.addAll(inv);
	}
}
