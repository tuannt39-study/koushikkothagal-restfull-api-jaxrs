package org.koushik.javabrains.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
//http://localhost:8080/webapi/injectdemo
public class InjectDemoResource {

    @GET
    @Path("annotations")
    //http://localhost:8080/webapi/injectdemo/annotations
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("authSessionID") String header,
                                            @CookieParam("name") String cookie) {
        return "Matrix param = " + matrixParam + " - Header param = " + header + " - Cookie param: " + cookie;
    }

    @GET
    @Path("context")
    //http://localhost:8080/webapi/injectdemo/context
    public String getParamsUsingContext(@Context UriInfo uriInfo) {
        String path = uriInfo.getAbsolutePath().toString();
        return "Path = " + path;
    }
}