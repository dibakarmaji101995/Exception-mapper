package com.nt.exceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.nt.customexception.NoValueFoundException;
import com.nt.domain.ErrorConfig;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<NoValueFoundException> {
	public CustomExceptionMapper() {
		System.out.println("CustomExceptionMapper.CustomExceptionMapper()");
	}

	public Response toResponse(NoValueFoundException exception) {
		System.out.println("CustomExceptionMapper.toResponse()");
		ErrorConfig ec=null;
		//create ErrorConfig object
		ec=new ErrorConfig();
		//set value to ErrorConfig object fields
		ec.setStatusCode(400);
		ec.setReason("Invalid Id Number");
		ec.setMessage(exception.getMessage());
		return Response.status(400).entity(ec).type(MediaType.APPLICATION_JSON).build();
	}

}
