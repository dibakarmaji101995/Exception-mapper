package com.nt.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nt.customexception.NoValueFoundException;
import com.nt.domain.Customer;

@Path("/cust")
public class CustomerResource {
	public CustomerResource() {
		System.out.println("CustomerResource.CustomerResource()");
	}

	@GET
	@Path("{id}")
	@Produces(value= {MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public Response getCustomerDetails(@PathParam("id") String id) {
		System.out.println("CustomerResource.getCustomerDetails()");
		int cid = Integer.parseInt(id);
		// create Customer object
		Customer cust = new Customer();
		if (cid == 101) {
			// set value to customer object fields
			cust.setId(cid);
			cust.setName("raja");
			cust.setAddrs("hyd");
		}
		else {
			throw new NoValueFoundException("No Record found");
		}
		return Response.ok(cust).build();
	}
}
