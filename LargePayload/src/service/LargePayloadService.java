package service;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import domain.Invoice;
import domain.InvoiceList;
import domain.InvoiceManager;

@Path("/largePayload")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Stateless
public class LargePayloadService {

	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response create(Invoice invoice) {
		if (invoice==null) {
			throw new BadRequestException();
		}
		InvoiceManager.add(invoice);
		URI uri = uriInfo.getAbsolutePathBuilder().path(invoice.getInvoiceId()).build();
		return Response.created(uri).build();
	}
	
	@PUT
	public Response update(Invoice invoice) {
		Invoice original = InvoiceManager.update(invoice);
		if (original==null) {
			throw new NotFoundException();
		}
		return Response.ok(invoice).build();
	}
	
	@GET
	@Path("{invoiceId}")
	public Response get(@PathParam("invoiceId") String invoiceId) {
		Invoice inv = InvoiceManager.findInvoice(invoiceId);
		if(inv == null) {
			throw new NotFoundException();
		}
		return Response.ok(inv).build();
	}
	
	@GET
	public Response getAll() {
		InvoiceList invoiceList = InvoiceManager.getInvoices();
		GenericEntity<List<Invoice>> list = new GenericEntity<List<Invoice>>(invoiceList) {};
		return Response.ok(list).build();
	}
	
	@DELETE
	@Path("{invoiceId}")
	public Response delete(@PathParam("invoiceId") String invoiceId) {
		InvoiceManager.delete(invoiceId);
		return Response.noContent().build();
	}
	

}
