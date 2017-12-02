package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class InvoiceManager {

	private static InvoiceList invoices = new InvoiceList();
	
	static {
		InvoiceItem li1 = new InvoiceItem("pencil", "this is a pencil", 1.5);
		InvoiceItem li2 = new InvoiceItem("computer", "Apple Computer", 1500);
		List<InvoiceItem> items = new ArrayList<InvoiceItem>();
		items.add(li1);
		items.add(li2);
		Calendar calendar1 = new GregorianCalendar(2017,10,30);
		Calendar calendar2 = new GregorianCalendar(2017,10,30);
		invoices.add(new Invoice("001", calendar1, "Test", items));
		invoices.add(new Invoice("002", calendar2, "Test 2", items));
	}
	
	public static InvoiceList getInvoices() {
		return invoices;
	}

	public static Invoice findInvoice(String invoiceId) {
		for (Invoice inv : invoices) {
			if (inv.getInvoiceId().equals(invoiceId)) {
				return inv;
			}
		}
		return null;
	}
	
	public static Invoice update(Invoice invoice) {
		Invoice inv = InvoiceManager.findInvoice(invoice.getInvoiceId());
		if (inv == null) {
			return null;
		}
		for (Invoice i : invoices) {
			if (i.getInvoiceId().equalsIgnoreCase(invoice.getInvoiceId())) {
				i = invoice;
				return invoice;
			}
		}
		return null;
	}
	
	public static void add(Invoice invoice) {
		invoices.add(invoice);
	}
	
	public static void delete(String invoiceId) {
		Invoice invoice = InvoiceManager.findInvoice(invoiceId);
		invoices.remove(invoice);
	}
}
