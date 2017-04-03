package org.koushik.javabrains.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    //http://localhost:8080/webapi/messa
    public Response toResponse(Throwable ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://qa.hackademicshanoi.vn/");
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}