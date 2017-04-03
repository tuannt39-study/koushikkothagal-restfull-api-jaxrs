package org.koushik.javabrains.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    //http://localhost:8080/webapi/messages/100
    public Response toResponse(DataNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://qa.hackademicshanoi.vn/");
        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}